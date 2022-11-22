package com.yj.demo_ssmp;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlPrimaryKey;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yj.demo_ssmp.dao.PersonDao;
import com.yj.demo_ssmp.domain.Person;
import com.yj.demo_ssmp.service.IPersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
class DemoSsmpApplicationTests {
    @Autowired
    private PersonDao personDao;
    //springboot 有自动装配的功能
    @Autowired
    DataSource dataSource;
    @Autowired
    private IPersonService personService;



    @Test
    @DisplayName("查看 数据库连接池")
    void contextLoads() {
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource driverClass：" + druidDataSource.getDriverClassName());
        System.out.println("druidDataSource url：" + druidDataSource.getUrl());
        System.out.println("druidDataSource username：" + druidDataSource.getUsername());
        System.out.println("druidDataSource max-wait：" + druidDataSource.getMaxWait());
        System.out.println("druidDataSource max-active：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource min-idle：" + druidDataSource.getMinIdle());
        System.out.println("druidDataSource initial-size：" + druidDataSource.getInitialSize());
        System.out.println("druidDataSource keep-alive：" + druidDataSource.isKeepAlive());
    }




    @Test
    void selectById() {
        System.out.println("person 1: "  +  personDao.selectById(1));
    }
    @Test
    void save() {
        Person person = new Person();
        person.setName("杨大");
        person.setAge("100");
        person.setUuid(UUID.randomUUID().toString());
        System.out.println("person 1: "  +  personDao.insert(person));
    }

    @Test
    void selectPage() {
        Page page = new Page(1,10);
        personDao.selectPage(page , null);
    }


    @Test
    void getExcepton() {

        try {
            personService.getExcepton();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
