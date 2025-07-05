package com.wei.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class MessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Bean
    public void sendMsg(){
    	//设置消息过期的核心代码
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("3000");//设置消息过期时间
        
        Message message = MessageBuilder.withBody("hello world".getBytes()).andProperties(messageProperties).build();
        rabbitTemplate.convertAndSend("exchange.ttl.a","info",message);
        log.info("消息发送完毕，发送时间是："+new Date());
    }
}
