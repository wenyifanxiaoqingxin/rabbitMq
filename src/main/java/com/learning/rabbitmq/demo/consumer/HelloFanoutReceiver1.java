package com.learning.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/3/29.
 */
@Component
@RabbitListener(queues = "fanout.B")
public class HelloFanoutReceiver1 {

    @RabbitHandler
    public void process(String context){

        System.out.println("receiver B: "+context);
    }
}
