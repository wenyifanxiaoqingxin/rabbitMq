package com.learning.rabbitmq.demo.productor;

import com.learning.rabbitmq.demo.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by fx on 2018/3/29.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){

        String context = "hello "+new Date();
        System.out.println("sender:"+context);
        this.amqpTemplate.convertAndSend("hello",context);

    }

    public void send(int i){

        String context =String.valueOf(i)+new Date();
//        System.out.println("sender:"+context);
        this.amqpTemplate.convertAndSend("hello",context);

    }

    public void send(User user){


        this.amqpTemplate.convertAndSend("object",user);
    }
}
