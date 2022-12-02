package com.yj.springboot_bean.app;

import com.yj.springboot_bean.bean.Cat;
import com.yj.springboot_bean.config.SpringConfig5;
import com.yj.springboot_bean.config.SpringConfig6;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App6 {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig6.class);

        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name +"   " );
        }
    }
}
