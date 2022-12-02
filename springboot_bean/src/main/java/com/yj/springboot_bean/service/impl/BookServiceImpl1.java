package com.yj.springboot_bean.service.impl;

import com.yj.springboot_bean.service.BookService;
import org.springframework.stereotype.Service;


@Service("bookServiceImpl1")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check(String str) {
        System.out.println("BookServiceImpl-1");
    }
}
