package com.yj.springboot_mq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.FanoutExchangeParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/***
 * fanout类型的交换机只管收到消息后，进行发送，不管有没有发送成功。
 */
@Configuration
public class FanoutConfig {

    public final static String FANOUT_QUEUE_1="yj.fanout.queue1";
    public final static String FANOUT_QUEUE_2="yj.fanout.queue2";



    @Bean
    public Queue fanoutQueue1(){
        return new Queue(FANOUT_QUEUE_1);
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue(FANOUT_QUEUE_2);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        String name = "yj.fanout";
        System.out.println(name + " 消息交换机生成");
        return new FanoutExchange(name);
    }

    @Bean
    public Binding fanoutBinding(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutBinding2(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }





}
