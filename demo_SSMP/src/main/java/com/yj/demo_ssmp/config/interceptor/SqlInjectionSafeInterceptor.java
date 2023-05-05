package com.yj.demo_ssmp.config.interceptor;

import com.yj.demo_ssmp.config.SqlInjectionSafeString;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;


/**
 *  SqlInjectionSafeInterceptor 的拦截器，
 *  拦截被 @SqlInjectionSafeString 注解标记的方法参数和字段，将其中的危险字符进行转义。
 */
@Component
public class SqlInjectionSafeInterceptor implements HandlerInterceptor {
    private static final String[] DANGEROUS_CHARACTERS = {"'", "\"", ";", "\\", "<", ">", "(", ")", "&", "|", "#", "+", "-", "*", "%", "=", "@", "$", "`", "~"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 拦截方法参数
            MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
            if (methodParameters != null) {
                for (MethodParameter methodParameter : methodParameters) {
                    if (methodParameter.getParameterAnnotation(SqlInjectionSafeString.class) != null) {
                        String parameterValue = request.getParameter(methodParameter.getParameterName());
                        if (parameterValue != null) {
                            String safeValue = escapeDangerousCharacters(parameterValue);
                            request.setAttribute(methodParameter.getParameterName(), safeValue);
                        }
                    }
                }
            }
            // 拦截字段
            Object bean = handlerMethod.getBean();
            Field[] fields = bean.getClass().getDeclaredFields();
            if (fields != null) {
                for (Field field : fields) {
                    if (field.getAnnotation(SqlInjectionSafeString.class) != null) {
                        ReflectionUtils.makeAccessible(field);
                        try {
                            String fieldValue = (String) field.get(bean);
                            if (fieldValue != null) {
                                String safeValue = escapeDangerousCharacters(fieldValue);
                                ReflectionUtils.setField(field, bean, safeValue);
                            }
                        } catch (IllegalAccessException e) {
                            // ignore
                        }
                    }
                }
            }
        }
        return true;
    }
    private String escapeDangerousCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (ArrayUtils.contains(DANGEROUS_CHARACTERS, String.valueOf(c))) {
                    sb.append("\\").append(c);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}