package com.learning.rabbitmq.demo.vo;

/**
 * Created by fx on 2018/12/14.
 */
public class DataInfo {
    private UserInformationVo mine;
    private UserInformationVo to;

    public UserInformationVo getMine() {
        return mine;
    }

    public void setMine(UserInformationVo mine) {
        this.mine = mine;
    }

    public UserInformationVo getTo() {
        return to;
    }

    public void setTo(UserInformationVo to) {
        this.to = to;
    }
}
