package com.learning.rabbitmq.demo.service.impl;

import com.learning.rabbitmq.demo.common.vo.MenuTree;
import com.learning.rabbitmq.demo.dao.mybatis.MenuAuthMapper;
import com.learning.rabbitmq.demo.entity.mybatis.MenuAuth;
import com.learning.rabbitmq.demo.service.MenuAuthService;
import com.learning.rabbitmq.demo.util.NavUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fx on 2018/12/12.
 */
@Service
public class MenuAuthServiceImpl implements MenuAuthService{
    @Autowired
    private MenuAuthMapper menuAuthMapper;
    @Override
    public String menuTree(String ctx, String userId) {
        List<MenuTree> menuTreeList = menuAuthMapper.selectMenu("0", userId);
        return NavUtils.getMenuTree(ctx, menuTreeList);
    }
}
