package com.wei.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${my.exchangeName}")
    private String exchangeName;

    @Value("${my.queueName}")
    private String queueName;

    //创建交换机
    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder.directExchange(exchangeName).build();
    }

    //创建队列
    @Bean
    public Queue queue(){
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    public Binding binding(DirectExchange exchangeName,Queue queueName){
        return BindingBuilder.bind(queueName).to(exchangeName).with("info");
    }
}
