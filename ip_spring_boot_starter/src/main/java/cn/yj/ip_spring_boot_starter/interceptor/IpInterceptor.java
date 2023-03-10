package cn.yj.ip_spring_boot_starter.interceptor;

import cn.yj.ip_spring_boot_starter.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 使用拦截器，来对请求进行拦截，然后在把拦截器配置到系统拦截器中 @link cn.yj.ip_spring_boot_starter.config.SpringMVCConfig#addInterceptors
 */
public class IpInterceptor implements HandlerInterceptor {

    @Autowired
    private IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }
}
