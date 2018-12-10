package com.learning.rabbitmq.demo.productor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/3/30.
 */
@Component
public class FanoutSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){

        String context= "hi,fanout mes";
        this.rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }
}
