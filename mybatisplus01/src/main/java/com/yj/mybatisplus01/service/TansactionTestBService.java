package com.yj.mybatisplus01.service;

import com.yj.mybatisplus01.dao.OrderDao;
import com.yj.mybatisplus01.dao.UserDao;
import com.yj.mybatisplus01.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TansactionTestBService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TansactionTestAService testAService;

    @Transactional
    public void testDefaultA_default(){
        User user = new User();
        user.setAge(12);
        user.setId("1234569789");
        user.setName("A");
        userDao.insert(user);



        //这里的B方法里面发生了异常,需要回滚;当前方法没有发生异常,不用回滚.但是B的事务和当前方法的事务是同一个,提交和回滚就会发生冲突,所以,这里会回滚.
        try {
            testAService.testDefault_B();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Transactional
    public void testDefaultA_Atry_bDefault(){

        try {
            User user = new User();
            user.setAge(12);
            user.setId("1234569789");
            user.setName("A");
            userDao.insert(user);
            int a =1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        testAService.testDefault_noCatch();
    }


    @Transactional
    public void testDefaultA_default_REQUIRES_NEW(){
        User user = new User();
        user.setAge(12);
        user.setId("1234569789");
        user.setName("A");
        userDao.insert(user);

        try {
            testAService.testDefault_REQUIRES_NEW();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testDefault_REQUIRES_NEW(){
            User user = new User();
            user.setAge(12);
            user.setId("1234569789");
            user.setName("A");
            userDao.insert(user);
            testAService.testDefault_REQUIRES_NEW();
    }

    @Transactional
    public void testDefault_REQUIRES_NEW_tracatch(){
        User user = new User();
        user.setAge(12);
        user.setId("1234569789");
        user.setName("A");
        userDao.insert(user);

        try {
            testAService.testDefault_REQUIRES_NEW_trycatch();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("11111111111111111");
        }



    }

}
