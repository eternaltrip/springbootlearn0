package com.yj.demo02;


import com.yj.demo02.jobo.MyDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/begin")
public class Begin {


    @Autowired
    private MyDriver myDriver;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping
    public String getName(){
        System.out.println("is begin...base01");
        System.out.println(myDriver.toString());
        System.out.println(serverPort);
        return "is begin...base01";
    }
}
