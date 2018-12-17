package com.learning.rabbitmq.demo.common.vo;

import com.learning.rabbitmq.demo.vo.UserInformationVo;

import java.util.List;

/**
 * Created by fx on 2018/12/14.
 */
public class DataVo {

    private UserInformationVo mine;

    private List<FriendVo> friend;

    private List<GroupVo> group;

    public UserInformationVo getMine() {
        return mine;
    }

    public void setMine(UserInformationVo mine) {
        this.mine = mine;
    }

    public List<FriendVo> getFriend() {
        return friend;
    }

    public void setFriend(List<FriendVo> friend) {
        this.friend = friend;
    }

    public List<GroupVo> getGroup() {
        return group;
    }

    public void setGroup(List<GroupVo> group) {
        this.group = group;
    }
}
