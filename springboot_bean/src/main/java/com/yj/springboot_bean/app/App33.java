package com.yj.springboot_bean.app;

import com.yj.springboot_bean.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App33 {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig33.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name +"   ");
        }
        System.out.println(app.getBean("springConfig33"));
        SpringConfig33 springConfig33 = app.getBean("springConfig33" ,SpringConfig33.class);
        System.out.println(springConfig33.dog1());
        System.out.println(springConfig33.dog1());
        System.out.println(springConfig33.dog1());
    }
}
