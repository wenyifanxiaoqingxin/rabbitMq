package com.learning.rabbitmq.demo.config;

import com.learning.rabbitmq.demo.consumer.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fx on 2018/12/10.
 */
@Configuration
public class DirectExchangeConfig {

    //direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key 匹配时, 才会被交换器投送到绑定的队列中去.
    @Bean
    public Queue directQueue(){
        return new Queue("direct.queue");
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    @Bean
    Binding bindingDirectExchange(Queue directQueue, DirectExchange directExchange){
            return BindingBuilder.bind(directQueue).to(directExchange).with("direct.queue");
    }
}
