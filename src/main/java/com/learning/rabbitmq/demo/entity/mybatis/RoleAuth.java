package com.learning.rabbitmq.demo.entity.mybatis;

import javax.persistence.*;

@Table(name = "t_role_auth")
public class RoleAuth {
    @Id
    private String id;

    @Column(name = "c_role_id")
    private String roleId;

    @Column(name = "c_auth_id")
    private String authId;

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

    /**
     * @return c_auth_id
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * @param authId
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }
}