package com.learning.rabbitmq.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by fx on 2018/12/10.
 * 发送工具类
 */
@Component
public class RabbitMqSender implements RabbitTemplate.ConfirmCallback{
    public static Logger logger = LoggerFactory.getLogger(RabbitMqSender.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate =rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

        logger.info("回调消息id："+correlationData);
        if(b){
            logger.info("消息成功消费");
        }else{
            logger.info("消息消费失败"+s);
        }

    }

    /**
     * 发送到 指定routekey的指定queue
     * @param routeKey
     * @param obj
     */
    public void sendRabbitmqDirect(String exchangeName,String routeKey,String obj) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("发送消息id: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchangeName, routeKey , obj, correlationData);
    }

    /**
     * 所有发送到Topic Exchange的消息被转发到所有关心RouteKey中指定Topic的Queue上
     * @param routeKey
     * @param obj
     */
    public void sendRabbitmqTopic(String exchangeName,String routeKey,String obj) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("发送消息id: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(exchangeName, routeKey , obj, correlationData);
    }
}
