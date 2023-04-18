package com.yj.springboot_mq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/***
 *路由模式
 *根据路由的规则把消息发送到不同的队列
 * 1.一个路由key可以绑定到多个队列上（这样可以实现fanout的功能）
 * 2.也可以不同的路由key绑定不同的队列。
 */
@Configuration
public class DirectConfig {

    public static final String DIRECTQUEUE = "direct_queue";
    public static final String DIRECTQUEUE2 = "direct_queue2";

    public static final  String DIRECTEXCHANGE = "directExchange";
    public static final  String OBJECT_EX = "object.ex";

    public static String ROUTINGKEY = "test.direct.routingKey";
    public static String ROUTINGKEY2 = "test.direct.routingKey2";




    @Bean
    public Queue directQueue(){
        System.out.println(DIRECTQUEUE + " 消息队列生成");
        return  new Queue(DIRECTQUEUE);
    }
    @Bean
    public Queue directQueue2(){
        System.out.println(DIRECTQUEUE2 + " 消息队列生成");
        return  new Queue(DIRECTQUEUE2);
    }

    @Bean
    public DirectExchange directExchange(){
        System.out.println(DIRECTEXCHANGE + " 消息交换机生成");
        return new DirectExchange(DIRECTEXCHANGE);
    }

    @Bean
    public Binding bingdingDirect(){
        System.out.println(DIRECTEXCHANGE + "/" + DIRECTQUEUE + "/" + ROUTINGKEY +  " 绑定");
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(ROUTINGKEY);
    }
    @Bean
    public Binding bingdingDirect2(){
        System.out.println(DIRECTEXCHANGE + "/" + DIRECTQUEUE2 + "/" + ROUTINGKEY2 +  " 绑定");
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(ROUTINGKEY2);
    }




    @Bean
    public Queue objectQueue(){
        return new Queue("objectQueue");
    }



}
