package com.yj.springboot_bean.config;


import com.yj.springboot_bean.bean.Dog;
import com.yj.springboot_bean.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"applicationContext.xml","applicationContext_copy.xml"})
public class SpringConfig32 {
}
