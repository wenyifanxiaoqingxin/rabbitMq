package com.learning.rabbitmq.demo.vo;

/**
 * Created by fx on 2018/12/14.
 */
public class SendInfo {
    private String type;

    private DataInfo data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }
}
