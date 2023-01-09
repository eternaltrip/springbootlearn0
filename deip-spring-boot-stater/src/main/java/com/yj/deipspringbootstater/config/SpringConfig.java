package com.yj.deipspringbootstater.config;

import com.yj.deipspringbootstater.bean.Dog;
import com.yj.deipspringbootstater.bean.MyFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.yj.bean","com.yj.SpringConfig"})
public class SpringConfig {


    @Bean
    public Dog getDog(){
        return  new Dog();
    }
    @Bean
    public FactoryBean factoryBean(){
        return  new MyFactoryBean();
    }
}
