package com.learning.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fx on 2018/12/10.
 */
@Component
@RabbitListener(queues = "direct.queue")
public class Receiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("direct.queue Receiver: "+message);

    }

}
