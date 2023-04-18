package com.yj.springboot_mq.service;

import com.yj.springboot_mq.config.FanoutConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class MessageLister {


    //direct 交换机测试-begin
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "direct.queue1") ,
            exchange = @Exchange(name = "yj.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}))
    public void listenDirectExchange(String msg){
        System.out.println("direct_queue1 得到的消息: " + msg);
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "direct.queue2") ,
            exchange = @Exchange(name = "yj.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}))
    public void listenDirectExchange2(String msg){
        System.out.println("direct_queue2 得到的消息: " + msg);
    }
    //direct 交换机测试-end



    //fanout 交换机测试-begin
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_1 )
    public void listenFanout1(String msg){
        System.out.println(FanoutConfig.FANOUT_QUEUE_1 + " 得到的消息: " + msg);
    }
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_2 )
    public void listenFanout2(String msg){
        System.out.println(FanoutConfig.FANOUT_QUEUE_2 +" 得到的消息: " + msg);
    }
    //fanout 交换机测试-end



    //topic 交换机测试-begin
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "topic.queue1") ,
                    exchange = @Exchange(name = "yj.topic",type = ExchangeTypes.TOPIC),
                    key = "china.#"))
    public void listenTopic1(String msg){
        System.out.println("topic.queue1 得到的消息: " + msg);
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "topic.queue2") ,
                    exchange = @Exchange(name = "yj.topic",type = ExchangeTypes.TOPIC),
                    key = "#.weather"))
    public void listenTopic2(String msg){
        System.out.println("topic.queue2 得到的消息: " + msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "topic.queue3") ,
                    exchange = @Exchange(name = "yj.topic",type = ExchangeTypes.TOPIC),
                    key = "#.news"))
    public void listenTopic3(String msg){
        System.out.println("topic.queue3 得到的消息: " + msg);
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue(name = "topic.queue4") ,
                    exchange = @Exchange(name = "yj.topic",type = ExchangeTypes.TOPIC),
                    key = "us.#"))
    public void listenTopic4(String msg){
        System.out.println("topic.queue4 得到的消息: " + msg);
    }
    //topic 交换机测试-end



    @RabbitListener(queues = "objectQueue" )
    public void objectQueue(Map msg){
        System.out.println("objectQueue 得到的消息: " + msg);
    }


}
