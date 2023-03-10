package com.yj.springboot_bean.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.yj.springboot_bean.bean.Dog;
import com.yj.springboot_bean.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.yj.springboot_bean.bean , com.yj.springboot_bean.config"})
public class SpringConfig3 {

    @Bean
    public DruidDataSource getDataSource2(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }


    @Bean
    public Dog dog1(){
        return new Dog();
    }


    @Bean
    public DogFactoryBean dog2(){
        return new DogFactoryBean();
    }
}
