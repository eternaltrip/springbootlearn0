package com.yj.springboot_bean.bean;

import org.springframework.beans.factory.FactoryBean;

public class DogFactoryBean implements FactoryBean<Dog> {

    public Dog getObject() throws Exception {
        //这里可以先创建对象,然后设置相应的属性,
        //比如redis对象创建之后,可以设置相应的url和port以及用户名和密码,以及连接是否能够联通的检测
        //而,初级的bean的创建,只是调用了bean的构造方法来创建了一个bean,它里面的属性是没有的.
        return new Dog();
    }

    public Class<?> getObjectType() {
        return Dog.class;
    }
}
