package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.User;
import com.learning.rabbitmq.demo.entity.mybatis.UserExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    long countByExample(UserExample example);
     User getUser(String username);
}