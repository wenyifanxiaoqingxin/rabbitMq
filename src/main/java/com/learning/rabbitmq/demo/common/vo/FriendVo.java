package com.learning.rabbitmq.demo.common.vo;

import com.learning.rabbitmq.demo.vo.UserInformationVo;

import java.util.List;

/**
 * Created by fx on 2018/12/14.
 */
public class FriendVo {
    private String groupname;
    private String id;
    private List<UserInformationVo> list;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserInformationVo> getList() {
        return list;
    }

    public void setList(List<UserInformationVo> list) {
        this.list = list;
    }
}
