package com.learning.rabbitmq.demo.entity.mybatis;

import javax.persistence.*;

@Table(name = "t_friends_group")
public class FriendGroup {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "c_user_id")
    private String userId;

    /**
     * 关注状态
     */
    private String status;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_id")
    private String groupId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return c_user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取关注状态
     *
     * @return status - 关注状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置关注状态
     *
     * @param status 关注状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}