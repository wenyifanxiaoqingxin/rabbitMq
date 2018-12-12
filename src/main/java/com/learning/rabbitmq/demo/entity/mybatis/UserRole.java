package com.learning.rabbitmq.demo.entity.mybatis;

import javax.persistence.*;

@Table(name = "t_user_role")
public class UserRole {
    @Id
    private String id;

    @Column(name = "c_user_id")
    private String userId;

    @Column(name = "c_role_id")
    private String roleId;

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
     * @return c_role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}