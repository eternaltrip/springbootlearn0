package com.yj.mybatisplus01.service;

import com.yj.mybatisplus01.dao.OrderDao;
import com.yj.mybatisplus01.dao.UserDao;
import com.yj.mybatisplus01.domain.Order;
import com.yj.mybatisplus01.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TansactionTestAService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;


    @Transactional
    public void testDefault(){
        try {
            User user = new User();
            user.setAge(12);
            user.setId("1234569789");
            user.setName("A");
            userDao.insert(user);
            testDefault_B();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testDefault_noCatch(){
            User user = new User();
            user.setAge(12);
            user.setId("1234569789");
            user.setName("A");
            userDao.insert(user);
    }




    @Transactional
    public void testDefault_B(){
//        try {
            Order order = new Order();
            order.setBalance("1000");
            order.setId("110");
            order.setUserId("123456789");
            orderDao.insert(order);
            int a = 1/0;//这里有异常
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testDefault_REQUIRES_NEW(){
        Order order = new Order();
        order.setBalance("1000");
        order.setId("110");
        order.setUserId("123456789");
        orderDao.insert(order);
        int a = 1/0;//这里有异常
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testDefault_REQUIRES_NEW_trycatch(){
//        try {
            Order order = new Order();
            order.setBalance("1000");
            order.setId("110");
            order.setUserId("123456789");
            orderDao.insert(order);
            int a = 1/0;//这里有异常
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
