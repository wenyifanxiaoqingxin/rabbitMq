package com.learning.rabbitmq.demo.productor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/3/29.
 */
@Component
public class TopicSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(){

        String context = "hi,i am message 1";
        this.rabbitTemplate.convertAndSend("exchange","topic.message",context);
    }

    public void send2(){

        String contet =" hi,i am message 2";
        this.rabbitTemplate.convertAndSend("exchange","topic.messages",contet);
    }
}
