package com.yj.demo_ssmp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.yj.demo_ssmp.config.interceptor.SqlInjectionSafeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 启用拦截器，
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private SqlInjectionSafeInterceptor sqlInjectionSafeInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sqlInjectionSafeInterceptor);
    }


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //MP的拦截器,在里面加入分页拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}