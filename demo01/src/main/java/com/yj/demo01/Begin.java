package com.yj.demo01;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/begin")
public class Begin {


    @RequestMapping
    public String getName(){
        System.out.println("is begin...");
        return "is begin...";
    }
}
