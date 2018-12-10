package com.learning.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/3/29.
 */
@Component
@RabbitListener(queues = "topic.messages1")
public class HelloReceiver4 {

    @RabbitHandler
    public void process(String context){

        System.out.println("receiver4: "+context);
    }
}
