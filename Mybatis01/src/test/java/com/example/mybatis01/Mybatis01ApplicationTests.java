package com.example.mybatis01;

import com.example.mybatis01.dao.PersonDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatis01ApplicationTests {

    @Autowired
    private PersonDao personDao;

    @Test
    void contextLoads() {
        System.out.println(personDao.getById("1").toString());
    }

    @Test
    void count() {
        System.out.println(personDao.count());
    }


}
