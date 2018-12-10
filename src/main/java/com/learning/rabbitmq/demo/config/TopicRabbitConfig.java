package com.learning.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fx on 2018/3/29.
 */
@Configuration
public class TopicRabbitConfig {

    //根据routing_key自由的绑定不同的队列
    final static String message = "topic.message";
    final static String messages = "topic.messages";
    final static String messages1 = "topic.messages1";
    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages(){

        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    public Queue queueMessages1(){

        return new Queue(TopicRabbitConfig.messages1);
    }
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){

        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchaneMessages(Queue queueMessages,TopicExchange exchange){

        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    @Bean
    Binding bindingExchaneMessages1(Queue queueMessages1,TopicExchange exchange){

        return BindingBuilder.bind(queueMessages1).to(exchange).with("topic.messages");
    }
}
