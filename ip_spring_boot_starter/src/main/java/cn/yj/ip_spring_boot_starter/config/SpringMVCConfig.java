package cn.yj.ip_spring_boot_starter.config;

import cn.yj.ip_spring_boot_starter.interceptor.IpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 利用@Configuration(proxyBeanMethods = true)使该配置成为唯一的
 */
@Configuration(proxyBeanMethods = true)
public class SpringMVCConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor()).addPathPatterns("/**");
    }



    @Bean
    public IpInterceptor ipInterceptor(){
        return new IpInterceptor();
    }

}
