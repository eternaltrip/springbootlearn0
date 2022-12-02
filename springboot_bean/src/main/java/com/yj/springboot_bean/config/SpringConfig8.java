 package com.yj.springboot_bean.config;


 import com.yj.springboot_bean.bean.MyPostProcessor;
 import com.yj.springboot_bean.bean.MyRegistrar;
 import com.yj.springboot_bean.bean.MyRegistrar2;
 import com.yj.springboot_bean.bean.MyRegistrar3;
 import com.yj.springboot_bean.service.impl.BookServiceImpl1;
 import org.springframework.context.annotation.Import;


// @Import({BookServiceImpl1.class, MyRegistrar2.class, MyRegistrar3.class})
 @Import({BookServiceImpl1.class, MyRegistrar2.class,MyRegistrar3.class,  MyPostProcessor.class})
 public class SpringConfig8 {
 }
