package com.learning.rabbitmq.demo.vo;

/**
 * Created by fx on 2018/12/13.
 */
public class SendMessageVo {
    private String userName;
    private String userId;
    private String messages;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
