package com.yj.springboot_bean.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.yj.springboot_bean.bean.Cat;
import com.yj.springboot_bean.bean.Dog;
import com.yj.springboot_bean.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@Import({Dog.class, Cat.class ,Dbconfig.class})
public class SpringConfig4 {
}
