package com.learning.rabbitmq.demo.config.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * Created by fx on 2018/12/13.
 */

//配置类  将http中的session传入websocket中
public class GetHttpSessionConfigurator  extends ServerEndpointConfig.Configurator{
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession session = (HttpSession) request.getHttpSession();
        System.out.println("session对象："+session.getAttribute("user"));
        sec.getUserProperties().put(HttpSession.class.getName(),session);
    }
}
