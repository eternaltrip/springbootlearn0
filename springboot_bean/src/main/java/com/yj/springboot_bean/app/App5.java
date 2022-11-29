package com.yj.springboot_bean.app;

import com.yj.springboot_bean.bean.Cat;
import com.yj.springboot_bean.config.SpringConfig4;
import com.yj.springboot_bean.config.SpringConfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App5 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig5.class);

        app.registerBean("tomcat" , Cat.class , 1);
        app.registerBean("tomcat" , Cat.class ,2);

        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name +"   " );
        }
        System.out.println(app.getBean("tomcat").toString());
    }
}
