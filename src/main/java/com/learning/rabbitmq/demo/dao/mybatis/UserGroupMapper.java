package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.UserGroup;
import com.learning.rabbitmq.demo.entity.mybatis.UserGroupExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserGroupMapper extends Mapper<UserGroup> {
    long countByExample(UserGroupExample example);
}