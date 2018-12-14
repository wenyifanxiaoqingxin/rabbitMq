package com.learning.rabbitmq.demo.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.learning.rabbitmq.demo.dao.mybatis.UserMapper;
import com.learning.rabbitmq.demo.entity.mybatis.User;
import com.learning.rabbitmq.demo.vo.DataInfo;
import com.learning.rabbitmq.demo.vo.SendInfo;
import com.learning.rabbitmq.demo.vo.UserInformationVo;
import com.rabbitmq.client.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import com.alibaba.fastjson.JSON;

/**
 * Created by fx on 2018/10/18.
 */
@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class RabbitWebSocket {

    private static  RabbitPropertiesValue rabbitPropertiesValue;
    private static UserMapper userMapper;
    @Autowired
    public void setRabbitPropertiesValue(RabbitPropertiesValue rabbitPropertiesValue,UserMapper userMapper){
        RabbitWebSocket.rabbitPropertiesValue = rabbitPropertiesValue;
        RabbitWebSocket.userMapper = userMapper;
    }

    private static org.apache.logging.log4j.Logger log = LogManager.getLogger(RabbitWebSocket.class);

    private Session session;
    private static Map<String,User> httpSessions = new HashMap<>(4);
    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
    private static  int onlineCount = 0;
    private static CopyOnWriteArraySet<RabbitWebSocket> webSocketSet = new CopyOnWriteArraySet<RabbitWebSocket>();


    @OnOpen
    public void onOpen(@PathParam("userId") String userIds, Session session){
        this.session = session;
        User user = userMapper.selectByPrimaryKey(userIds);
        httpSessions.put(session.getId(),user);
        sessions.add(session);
        webSocketSet.add(this);
        addOnlineCount();
        log.info("新对象"+user.getUsername()+"加入！当前人数为："+getOnlineCount());
        String queneName = "closedPlace";



    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        sessions.remove(session);
        httpSessions.remove(session.getId());
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
        SendInfo sendInfo = JSON.parseObject(message,SendInfo.class);

        //单个人发送
        if("chatMessage".equals(sendInfo.getType())){
            try {
                sendMessageOneToOne(sendInfo.getData().getMine().getContent(),session,sendInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
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
                    s.getBasicRemote().sendText(httpSessions.get(session.getId()).getUsername()+"："+message);
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
    public void sendMessageOneToOne(String message,Session session,SendInfo sendInfo) throws IOException {
        UserInformationVo userInformationVo = sendInfo.getData().getMine();
        userInformationVo.setType("friend");
        userInformationVo.setMine(false);
        userInformationVo.setTimestamp(new Date().getTime());
        //阻塞式的(同步的)
        if (sessions.size() != 0) {
            for (Session s : sessions) {
                if (s != null &&httpSessions.get(s.getId()).getId().equals(sendInfo.getData().getTo().getId())){
                    s.getBasicRemote().sendText(JSON.toJSONString(userInformationVo));
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
