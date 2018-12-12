package com.learning.rabbitmq.demo.common;

import com.rabbitmq.client.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/**
 * Created by fx on 2018/10/18.
 */
@ServerEndpoint(value = "/websocket")
@Component
public class RabbitWebSocket {

    private static  RabbitPropertiesValue rabbitPropertiesValue;
    @Autowired
    public void setRabbitPropertiesValue(RabbitPropertiesValue rabbitPropertiesValue){
        RabbitWebSocket.rabbitPropertiesValue = rabbitPropertiesValue;
    }

    private static org.apache.logging.log4j.Logger log = LogManager.getLogger(RabbitWebSocket.class);

    private Session session;
    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
    private static  int onlineCount = 0;
    private static CopyOnWriteArraySet<RabbitWebSocket> webSocketSet = new CopyOnWriteArraySet<RabbitWebSocket>();


    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        sessions.add(session);
        webSocketSet.add(this);
        addOnlineCount();
        log.info("新对象加入！当前人数为："+getOnlineCount());
        String queneName = "closedPlace";
        try {
            //创建连接连接到MabbitMQ
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(rabbitPropertiesValue.getHost());
            connectionFactory.setUsername(rabbitPropertiesValue.getUsername());
            connectionFactory.setPassword(rabbitPropertiesValue.getPwd());
            connectionFactory.setPort(Integer.parseInt(rabbitPropertiesValue.getPort()));
            //创建连接
            Connection connection = connectionFactory.newConnection();
            //创建频道
            Channel channel =connection.createChannel();
            channel.exchangeDeclare("exchange","topic",true,false,null);
            channel.queueDeclare(queneName,true,false,false,null);
            channel.queueBind(queneName,"exchange","exchange");

            channel.basicQos(1);

            log.info("[*]waiting for messages");

            //监听
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //处理监听得到的消息
                    String message = null;
                    try {
                        message = new String(body, "UTF-8");
                        //消息处理逻辑
                        sendMessageAll(message);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        channel.abort();
                    } finally {
                        log.info("[x] Done.");
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                    log.info("[x] Received '" + message + "'");
                }
            };


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        sessions.remove(session);
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:" + message);
        //群发消息
        for (RabbitWebSocket item : webSocketSet) {
            if(item.session == session){
                continue;
            }
            try {
                item.sendMessage(message,session);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message,Session session) throws IOException {
        //阻塞式的(同步的)
        if (sessions.size() != 0) {
            for (Session s : sessions) {
                if (s != null &&s!=session){
                    s.getBasicRemote().sendText(session.getId()+":"+message);
                }
            }
        }

        //非阻塞式的（异步的）
//        this.session.getAsyncRemote().sendText(message);
        log.info("[x] 推送消息"+message);
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessageAll(String message) throws IOException {
        //阻塞式的(同步的)
        if (sessions.size() != 0) {
            for (Session s : sessions) {
                if (s != null){
                    s.getBasicRemote().sendText(message);
                }
            }
        }

        //非阻塞式的（异步的）
//        this.session.getAsyncRemote().sendText(message);
        log.info("[x] 推送消息"+message);
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        RabbitWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        RabbitWebSocket.onlineCount--;
    }
}
