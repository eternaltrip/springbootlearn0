package com.yj.springboot_mq.service;

import com.yj.springboot_mq.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageLister {


    @RabbitListener(queues = RabbitConfig.DIRECTQUEUE )
    public void receive(String msg){
        System.out.println("DIRECTQUEUE 得到的消息: " + msg);
    }

    @RabbitListener(queues = RabbitConfig.DIRECTQUEUE2 )
    public void receive1(String msg){
        System.out.println("DIRECTQUEUE2 得到的消息: " + msg);
    }



        @RabbitListener(queues = RabbitConfig.TOP_QUEUE )
    public void receive2(String msg){
        System.out.println("top 1 得到的消息: " + msg);
    }


    @RabbitListener(queues = RabbitConfig.TOP_QUEUE2 )
    public void receive3(String msg){
        System.out.println("top 2 得到的消息: " + msg);
    }


}
