package com.bonc.migu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@MapperScan("com.bonc.migu.mapper")
@SpringBootApplication
public class MobileLevelApp {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(MobileLevelApp.class, args);
        System.out.println("启动");
//        for (String beanDefinitionName : context.getBeanFactory().getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }

    }

}
