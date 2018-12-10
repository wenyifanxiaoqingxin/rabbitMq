package com.learning.rabbitmq.demo.entity;

import java.io.Serializable;

/**
 * Created by fx on 2018/3/29.
 */
public class User implements Serializable{

    private String userName;
    private String pass;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
