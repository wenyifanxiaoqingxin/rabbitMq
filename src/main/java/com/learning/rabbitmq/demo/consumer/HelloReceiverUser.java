package com.learning.rabbitmq.demo.consumer;

import com.learning.rabbitmq.demo.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/3/29.
 */
@Component
@RabbitListener(queues = "object")
public class HelloReceiverUser {

    @RabbitHandler
    public void process(User user){

        System.out.println("receiverObject: "+user);
    }
}
