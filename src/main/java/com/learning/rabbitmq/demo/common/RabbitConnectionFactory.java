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
 * 重新构造connection对象及消费队列回调
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
        container.setQueueNames(new String[]{"direct.queue","topic.messages"});
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //消费者手动指定回调
        container.setupMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                try {
                    byte[] body = message.getBody();
                    System.out.println("消费者端接收到消息 : "+new String(body));
                    // deliveryTag是消息传送的次数，我这里是为了让消息队列的第一个消息到达的时候抛出异常，处理异常让消息重新回到队列，然后再次抛出异常，处理异常拒绝让消息重回队列
//                    if (message.getMessageProperties().getDeliveryTag() == 1
//                            || message.getMessageProperties().getDeliveryTag() == 2) {
//                        throw new Exception();
//                    }
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);//确认消息被成功消费
                }catch (Exception e){
                    e.printStackTrace();
                    if(message.getMessageProperties().getRedelivered()){
                        System.out.println("消息已重复处理失败,拒绝再次接收...");
                        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
                    }else{
                        System.out.println("消息即将再次返回队列处理...");
                        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);// requeue为是否重新回到队列
                    }
                }

            }
        });
        //监听池中器配置
//        container.setMessageListener(messageListenerAdapter);
        return container;
    }

}
