package com.yj.springboot_mq.service;


import com.yj.springboot_mq.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendMessage {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECTEXCHANGE , RabbitConfig.ROUTINGKEY , msg);
        System.out.println("发送消息: " + msg);
    }


    public void sendTopMsg(String msg){

        // # 代表匹配任意次, * 代表匹配一次
        rabbitTemplate.convertAndSend(RabbitConfig.TOP_EXCHANGE , "*.*.routingkey" , msg);
        rabbitTemplate.convertAndSend(RabbitConfig.TOP_EXCHANGE , "#.routingkey" , msg);
        System.out.println("发送消息: " + msg);
    }

}
