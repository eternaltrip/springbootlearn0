package com.bonc.migu.utils;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ReturnObject {
    private Boolean flag;
    private Object data;
    private String msg;
    private int code;

    public static final int SYS_ERROR_CODE = 9999;
    public static final String SYS_ERROR_MSG = "系统错误！";
    public static final int PARAM_ERROR_CODE = 461;
    public static final String PARAM_ERROR_MSG = "参数有误！";


    public static ReturnObject OK(Object data){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = true;
        returnObject.code = HttpStatus.OK.value();
        returnObject.msg = HttpStatus.OK.name();
        returnObject.data = data;
        return returnObject;
    }
    public static ReturnObject OK(Object data ,String msg){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = true;
        returnObject.code = HttpStatus.OK.value();
        returnObject.msg = HttpStatus.OK.name();
        returnObject.data = data;
        return returnObject;
    }

    public static ReturnObject error(int code,String msg){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = false;
        returnObject.msg = msg;
        returnObject.code = code;
        return returnObject;
    }

    public static ReturnObject sys_error(Object data){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = false;
        returnObject.msg = SYS_ERROR_MSG;
        returnObject.code = SYS_ERROR_CODE;
        returnObject.data = data;
        return returnObject;
    }

    public static ReturnObject param_error(String msg){
        ReturnObject returnObject = new ReturnObject();
        returnObject.flag = false;
        returnObject.msg = msg;
        returnObject.code = PARAM_ERROR_CODE;
        return returnObject;
    }

}
