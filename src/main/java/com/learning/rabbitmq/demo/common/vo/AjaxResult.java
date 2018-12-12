package com.learning.rabbitmq.demo.common.vo;

import java.io.Serializable;

/**
 * Created by yangzy on 2018/11/1.
 */
public class AjaxResult implements Serializable {

    public static final String SUCCESS = "0000";
    public static final String FAIL = "0001";

    private String code;
    private String message;
    private Object data;
    private long total;
    private int currentPage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
