package com.learning.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fx on 2018/3/30.
 */
@Configuration
public class FanoutRabbitConfig {
//Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
    @Bean
    public Queue AMessage(){

        return new Queue("fanout.A");
    }
    @Bean
    public Queue AMessage2(){

        return new Queue("fanout.A2");
    }
    @Bean
    public Queue BMessage(){


        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage(){

        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){

        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){

        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){

        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){

        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
