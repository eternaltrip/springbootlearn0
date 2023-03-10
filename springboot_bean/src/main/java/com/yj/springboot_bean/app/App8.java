package com.yj.springboot_bean.app;

import com.yj.springboot_bean.config.SpringConfig8;
import com.yj.springboot_bean.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App8 {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig8.class);
        BookService bookService = app.getBean("bookService" , BookService.class);
        bookService.check(null);

    }
}
