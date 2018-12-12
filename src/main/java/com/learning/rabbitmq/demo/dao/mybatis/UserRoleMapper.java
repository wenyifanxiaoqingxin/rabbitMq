package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.UserRole;
import com.learning.rabbitmq.demo.entity.mybatis.UserRoleExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserRoleMapper extends Mapper<UserRole> {
    long countByExample(UserRoleExample example);
}