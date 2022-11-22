package com.yj.mybatisplus01;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yj.mybatisplus01.dao.PersonDao;
import com.yj.mybatisplus01.service.TansactionTestAService;
import com.yj.mybatisplus01.service.TansactionTestBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatisplus01ApplicationTests {


    @Autowired
    private PersonDao personDao;
    @Autowired
    private TansactionTestAService testAService;
    @Autowired
    private TansactionTestBService bService;


    @Test
    void contextLoads() {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("id",1);
        System.out.println(personDao.selectOne(queryWrapper));
    }
    @Test
    void count() {
        System.out.println(personDao.selectCount(null));
    }


    @Test
    void testTransaction() {
        testAService.testDefault();
    }

    @Test
    void testTransaction_classB() {
        bService.testDefaultA_default();
    }


    @Test
    void testTransaction_classB_REQUIRES_NEW() {
        bService.testDefault_REQUIRES_NEW();
    }

    @Test
    void testTransaction_classB_default_REQUIRES_NEW() {
        bService.testDefaultA_default_REQUIRES_NEW();
    }
    @Test
    void testDefault_REQUIRES_NEW_tracatch() {
        bService.testDefault_REQUIRES_NEW_tracatch();
    }
    @Test
    void testDefaultA_Atry_bDefault() {
        bService.testDefaultA_Atry_bDefault();
    }
}
