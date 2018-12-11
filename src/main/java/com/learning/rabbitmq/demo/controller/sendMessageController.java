package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.util.RabbitMqSender;
import com.learning.rabbitmq.demo.vo.SendMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2018/10/17.
 */
@Controller
@RequestMapping("/rabbit")
public class sendMessageController {

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @RequestMapping("/send")
    @ResponseBody
    public String send(@RequestBody SendMessage sendMessage){
        rabbitMqSender.sendRabbitmqTopic(sendMessage.getExchangeName(),sendMessage.getRoutingKey(),sendMessage.getMessage());
        return "success";
    }

}
