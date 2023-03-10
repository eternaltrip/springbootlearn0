package com.yj.springboot_jetcache.utils;


import lombok.Data;

@Data
public class ReturnObject {
    private Boolean flag;
    private Object data;
    private String msg;


    public static ReturnObject OK(Object data){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = true;
        returnObject.data = data;
        returnObject.msg = "操作成功!";
        return returnObject;
    }
    public static ReturnObject OK(Object data ,String msg){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = true;
        returnObject.data = data;
        returnObject.msg = msg;
        return returnObject;
    }

    public static ReturnObject error(String msg){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = false;
        returnObject.msg = msg;
        return returnObject;
    }

}
