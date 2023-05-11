package com.bonc.migu.utils.advice;


import com.bonc.migu.utils.ReturnObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * 全局异常类处理类
 */
//@ControllerAdvice
    @Slf4j
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public ReturnObject doException(Exception exception){
        //记录日志
        //通知运维
        //通知开发
        exception.printStackTrace();
        log.error("异常发生", exception );
        return ReturnObject.sys_error(exception.getMessage());

    }





}
