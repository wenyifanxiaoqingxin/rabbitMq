package com.learning.rabbitmq.demo.common.vo;

import com.learning.rabbitmq.demo.entity.mybatis.MenuAuth;

import java.util.List;

/**
 * Created by fx on 2018/12/12.
 */
public class MenuTree extends MenuAuth{
    private String userId;

    private List<MenuTree> subMenu;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<MenuTree> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuTree> subMenu) {
        this.subMenu = subMenu;
    }

    public String getTreeHtml(String ctx){
        StringBuilder builder = new StringBuilder();
        builder.append("<li>");
        if (subMenu != null && subMenu.size() > 0){
            builder.append("<a href='javascript:;'>");
            builder.append("<i class='iconfont'>&#xe6b8;</i>");
            builder.append("<cite>");
            builder.append(getAuthName());
            builder.append("</cite>");
            builder.append("<i class='iconfont nav_right'>&#xe697;</i>");
            builder.append("</a>");
            builder.append("<ul class='sub-menu'>");
            for (MenuAuth financeAuth : subMenu){
                builder.append("<li>");
                builder.append("<a _href='").append(financeAuth.getAuthUrl()).append("'>");
                builder.append("<i class='iconfont'>&#xe6a7;</i>");
                builder.append("<cite>").append(financeAuth.getAuthName()).append("</cite>");
                builder.append("</a>");
                builder.append("</li>");
            }
            builder.append("</ul>");
        }
        builder.append("</li>");

        return builder.toString();
    }
}
