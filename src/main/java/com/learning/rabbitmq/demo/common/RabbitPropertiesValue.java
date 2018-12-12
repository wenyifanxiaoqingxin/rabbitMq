package com.learning.rabbitmq.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/10/18.
 */
@Component
public class RabbitPropertiesValue {

    @Value("${spring.application.name}")
    private String  name;
    @Value("${spring.rabbitmq.host}")
    private String  host;
    @Value("${spring.rabbitmq.port}")
    private String  port;
    @Value("${spring.rabbitmq.username}")
    private String  username;
    @Value("${spring.rabbitmq.password}")
    private String  pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
