package com.learning.rabbitmq.demo.common;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by fx on 2018/12/10.
 */
@Configuration
public class RabbitConnectionFactory {
    public static Logger logger = LoggerFactory.getLogger(RabbitConnectionFactory.class);
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private String port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.virtual-host}")
    private String vhost;

    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,Integer.parseInt(port));
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean(name="rabbitTemplate")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                logger.info("回调id："+correlationData);
                if(b){
                    logger.info("消息成功消费");
                }else{
                    logger.info("消息消费失败"+s);
                }
            }
        });
        return  rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setConnectionFactory(connectionFactory());
        return  factory;
    }
    //第二种自定义监听方式，重写监听容器方法第一种为在receiver注解@@RabbitListener(queues = "XXX")
    @Bean
    SimpleMessageListenerContainer container(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageConverter(new Jackson2JsonMessageConverter());
        //监听队列名称
        container.setQueueNames(new String[]{"direct.queue"});
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setupMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                byte[] body = message.getBody();
                System.out.println("receiver msg : "+new String(body));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//确认消息被成功消费
            }
        });
        //监听池中器配置
//        container.setMessageListener(messageListenerAdapter);
        return container;
    }

//    //被监听的类
//    @Bean
//    Receiver receiver(){
//        return new Receiver();
//    }
//    //监听器配置
//    @Bean
//    MessageListenerAdapter messageListenerAdapter(Receiver receiver){
//        return new MessageListenerAdapter(receiver,"receiverMessage");
//    }
}
