package com.yj.demo_ssmp.controller.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志
 */
public class BaseClass {
    private Class clazz;
    public static Logger logger;

    public BaseClass() {
        this.clazz = this.getClass();
        logger = LoggerFactory.getLogger(this.clazz);
    }
}
