package com.yj.springboot_bean.app;

import com.yj.springboot_bean.config.SpringConfig3;
import com.yj.springboot_bean.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig4.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name +"   " );
        }
    }
}
