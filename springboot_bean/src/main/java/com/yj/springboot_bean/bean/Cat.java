package com.yj.springboot_bean.bean;


import org.springframework.stereotype.Component;

@Component("jumpcat")
public class Cat {
    public Cat(){
    }
    int age;
    public Cat(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
