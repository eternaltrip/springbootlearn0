package com.yj.demo02;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/begin")
public class Begin {


    @RequestMapping
    public String getName(){
        System.out.println("is begin...2");
        return "is begin...2";
    }
}
