package com.learning.rabbitmq.demo.vo;

import java.io.Serializable;

/**
 * Created by fx on 2018/10/17.
 */
public class SendMessage implements Serializable{
    private String message;

    private String exchangeName;

    private String routingKey;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
