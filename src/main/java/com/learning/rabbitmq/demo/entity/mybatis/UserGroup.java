package com.learning.rabbitmq.demo.entity.mybatis;

import javax.persistence.*;

@Table(name = "t_user_group")
public class UserGroup {
    @Id
    private String id;

    @Column(name = "c_user_id")
    private String userId;

    @Column(name = "c_group_id")
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
     * @return c_user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return c_group_id
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