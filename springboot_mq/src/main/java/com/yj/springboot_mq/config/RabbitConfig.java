package com.yj.springboot_mq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/***
 * RABBIT_MQ 需要队列,交换机,和路由.
 *  最后把队列通过路由绑定到交换机上
 */
@Configuration
public class RabbitConfig {

    public static final String DIRECTQUEUE = "direct_queue";
    public static final String DIRECTQUEUE2 = "direct_queue2";
    public static final  String DIRECTEXCHANGE = "directExchange";
    public static String ROUTINGKEY = "test.direct.routingKey";



    public static final String TOP_QUEUE = "top_queue";
    public static final String TOP_QUEUE2 = "top_queue2";
    public static final  String TOP_EXCHANGE = "top_exchange";
    public static String TOP_ROUTINGKEY = "test.top.routingkey";



    @Bean
    public Queue directQueue(){
        System.out.println(DIRECTQUEUE + " 消息队列生成");
        return  new Queue(DIRECTQUEUE);
    }

    @Bean
    public DirectExchange directExchange(){
        System.out.println(DIRECTEXCHANGE + " 消息交换机生成");
        return new DirectExchange(DIRECTEXCHANGE);
    }
    @Bean
    public Binding bingdingDirect(){
        System.out.println(DIRECTEXCHANGE + "" + DIRECTQUEUE + "" + ROUTINGKEY +  " 绑定");
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(ROUTINGKEY);
    }

    @Bean
    public Queue topQueue(){
        System.out.println(TOP_QUEUE + " 消息队列生成");
        return  new Queue(TOP_QUEUE);
    }
    @Bean
    public Queue topQueue2(){
        System.out.println(TOP_QUEUE2 + " 消息队列生成");
        return  new Queue(TOP_QUEUE2);
    }

    @Bean
    public DirectExchange topExchange(){
        System.out.println(TOP_EXCHANGE + " 消息交换机生成");
        return new DirectExchange(TOP_EXCHANGE);
    }
    @Bean
    public Binding bingdingTop(){
        System.out.println(TOP_EXCHANGE + "" + TOP_QUEUE + "" + TOP_ROUTINGKEY +  " 绑定");
        return BindingBuilder.bind(topQueue()).to(topExchange()).with(TOP_ROUTINGKEY);
    }
    @Bean
    public Binding bingdingTop2(){
        System.out.println(TOP_EXCHANGE + "" + TOP_QUEUE2 + "" + TOP_ROUTINGKEY +  " 绑定");
        return BindingBuilder.bind(topQueue2()).to(topExchange()).with(TOP_ROUTINGKEY);
    }





}
