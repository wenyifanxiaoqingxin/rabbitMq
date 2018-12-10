package com.learning.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fx on 2018/3/29.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public List<Queue> queue(){

        List<Queue> queues = new ArrayList<>();
        queues.add(new Queue("object"));
        queues.add(new Queue("hello"));
        return queues;
    }
    final static String message = "closedPlace";
    final static String messages = "topic.messages";

    //创建队列
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitConfig.message);
    }

    //创建队列
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitConfig.messages);
    }

    //创建交换器
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    //对列绑定并关联到ROUTINGKEY
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with(RabbitConfig.message);
    }

    //对列绑定并关联到ROUTINGKEY
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
