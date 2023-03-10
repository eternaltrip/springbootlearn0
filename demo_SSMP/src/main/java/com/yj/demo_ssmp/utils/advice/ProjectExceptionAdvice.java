package com.yj.demo_ssmp.utils.advice;


import com.yj.demo_ssmp.utils.ReturnObject;
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
        log.error("异常发生");
        return ReturnObject.error("服务器异常,请稍后再试!");

    }

}
