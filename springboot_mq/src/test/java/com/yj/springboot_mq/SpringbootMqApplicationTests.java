package com.yj.springboot_mq;

import com.yj.springboot_mq.service.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootMqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    void sendFanoutMsg(){
            // # 代表匹配任意次, * 代表匹配一次
        rabbitTemplate.convertAndSend("yj.fanout" , "" , "fanout msg hello ,你们");
    }


    @Test
    void sendDirectMsg(){
        String color = "red";
        // # 代表匹配任意次, * 代表匹配一次
        rabbitTemplate.convertAndSend("yj.direct" , color , "direct msg ,color is  " + color);
        color = "yellow";
        rabbitTemplate.convertAndSend("yj.direct" , color , "direct msg ,color is  " + color);
        color = "blue";
        rabbitTemplate.convertAndSend("yj.direct" , color , "direct msg ,color is  " + color);
    }

    @Test
    void sendTopicMsg(){
        // # 代表匹配任意次, * 代表匹配一次
      //  rabbitTemplate.convertAndSend("yj.topic" , "china.news" , "今天最大的新新闻");
        rabbitTemplate.convertAndSend("yj.topic" , "us.news" , "us今天最大的新新闻");
    }

    @Test
    void sendObjectMsg(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("name","jack chen");
        obj.put("age" , 50);
        rabbitTemplate.convertAndSend("objectQueue"  , obj);
    }


}
