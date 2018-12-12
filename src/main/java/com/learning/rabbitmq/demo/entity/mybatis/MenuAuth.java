package com.learning.rabbitmq.demo.entity.mybatis;

import javax.persistence.*;

@Table(name = "menu_auth")
public class MenuAuth {
    @Id
    private String id;

    /**
     * 权限名称
     */
    @Column(name = "auth_name")
    private String authName;

    /**
     * 资源路径
     */
    @Column(name = "auth_url")
    private String authUrl;

    /**
     * 权限字符串
     */
    @Column(name = "auth_permission")
    private String authPermission;

    /**
     * 权限类型
0：菜单
1：按钮
     */
    @Column(name = "auth_type")
    private String authType;

    /**
     * 权限状态
0：未启用
1：启用
     */
    @Column(name = "auth_status")
    private String authStatus;

    /**
     * 权限描述
     */
    @Column(name = "auth_descrtion")
    private String authDescrtion;

    /**
     * 父级菜单
     */
    @Column(name = "auth_parent_id")
    private String authParentId;

    @Column(name = "auth_order")
    private Integer authOrder;

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
     * 获取权限名称
     *
     * @return auth_name - 权限名称
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * 设置权限名称
     *
     * @param authName 权限名称
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     * 获取资源路径
     *
     * @return auth_url - 资源路径
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * 设置资源路径
     *
     * @param authUrl 资源路径
     */
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    /**
     * 获取权限字符串
     *
     * @return auth_permission - 权限字符串
     */
    public String getAuthPermission() {
        return authPermission;
    }

    /**
     * 设置权限字符串
     *
     * @param authPermission 权限字符串
     */
    public void setAuthPermission(String authPermission) {
        this.authPermission = authPermission;
    }

    /**
     * 获取权限类型
0：菜单
1：按钮
     *
     * @return auth_type - 权限类型
0：菜单
1：按钮
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 设置权限类型
0：菜单
1：按钮
     *
     * @param authType 权限类型
0：菜单
1：按钮
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    /**
     * 获取权限状态
0：未启用
1：启用
     *
     * @return auth_status - 权限状态
0：未启用
1：启用
     */
    public String getAuthStatus() {
        return authStatus;
    }

    /**
     * 设置权限状态
0：未启用
1：启用
     *
     * @param authStatus 权限状态
0：未启用
1：启用
     */
    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * 获取权限描述
     *
     * @return auth_descrtion - 权限描述
     */
    public String getAuthDescrtion() {
        return authDescrtion;
    }

    /**
     * 设置权限描述
     *
     * @param authDescrtion 权限描述
     */
    public void setAuthDescrtion(String authDescrtion) {
        this.authDescrtion = authDescrtion;
    }

    /**
     * 获取父级菜单
     *
     * @return auth_parent_id - 父级菜单
     */
    public String getAuthParentId() {
        return authParentId;
    }

    /**
     * 设置父级菜单
     *
     * @param authParentId 父级菜单
     */
    public void setAuthParentId(String authParentId) {
        this.authParentId = authParentId;
    }

    /**
     * @return auth_order
     */
    public Integer getAuthOrder() {
        return authOrder;
    }

    /**
     * @param authOrder
     */
    public void setAuthOrder(Integer authOrder) {
        this.authOrder = authOrder;
    }
}