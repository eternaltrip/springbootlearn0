package com.yj.springboot_bean.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.yj.springboot_bean.bean.Dog;
import com.yj.springboot_bean.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


public class SpringConfig31 {

    @Bean
    public Dog dog1(){
        return new Dog();
    }


    @Bean
    public DogFactoryBean dog2(){
        return new DogFactoryBean();
    }
}
