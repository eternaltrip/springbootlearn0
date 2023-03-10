package com.yj.springboot_bean.app;

import com.yj.springboot_bean.config.SpringConfig7;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App7 {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig7.class);

        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name +"   " );
        }
    }
}
