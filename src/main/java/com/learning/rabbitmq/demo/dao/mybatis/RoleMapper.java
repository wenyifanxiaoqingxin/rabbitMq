package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.Role;
import com.learning.rabbitmq.demo.entity.mybatis.RoleExample;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    long countByExample(RoleExample example);
}