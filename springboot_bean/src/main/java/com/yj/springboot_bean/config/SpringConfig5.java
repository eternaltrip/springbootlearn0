package com.yj.springboot_bean.config;


import com.yj.springboot_bean.bean.Dog;
import org.springframework.context.annotation.Import;


@Import({Dog.class, Dbconfig.class})
public class SpringConfig5 {
}
