package com.yj.springboot_bean.service.impl;

import com.yj.springboot_bean.service.BookService;

public class BookServiceImpl2 implements BookService {
    @Override
    public void check(String str) {
        System.out.println("BookServiceImpl-2");
    }
}
