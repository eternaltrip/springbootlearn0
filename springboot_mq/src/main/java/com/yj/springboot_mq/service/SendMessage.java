package com.yj.springboot_mq.service;


import com.yj.springboot_mq.config.DirectConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class SendMessage {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg){
        int num = new Random().nextInt(200);
        if(num % 2 == 0){
            rabbitTemplate.convertAndSend(DirectConfig.DIRECTEXCHANGE , DirectConfig.ROUTINGKEY , msg);
            System.out.println("sendMsg发送消息=> direct_queue: " + msg);
        }else{
            rabbitTemplate.convertAndSend(DirectConfig.DIRECTEXCHANGE , DirectConfig.ROUTINGKEY2 , msg);
            System.out.println("sendMsg发送消息=> direct_queue2: " + msg);
        }
    }


    public void fanoutSend(String msg){
        // # 代表匹配任意次, * 代表匹配一次
        rabbitTemplate.convertAndSend("yj.fanout" , "" , msg);
        System.out.println("sendTopMsg发送消息: " + msg);
    }

}
