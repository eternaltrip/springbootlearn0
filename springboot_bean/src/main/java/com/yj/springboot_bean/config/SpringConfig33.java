package com.yj.springboot_bean.config;


import com.yj.springboot_bean.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false)
public class SpringConfig33 {
    @Bean
    public Dog dog1(){
        return new Dog();
    }

}
