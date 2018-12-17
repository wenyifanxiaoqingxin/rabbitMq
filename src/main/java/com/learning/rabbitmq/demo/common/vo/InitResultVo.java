package com.learning.rabbitmq.demo.common.vo;

import java.io.Serializable;

/**
 * Created by fx on 2018/12/14.
 */
public class InitResultVo implements Serializable{
    private String code;
    private String msg;

    private DataVo data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataVo getData() {
        return data;
    }

    public void setData(DataVo data) {
        this.data = data;
    }
}
