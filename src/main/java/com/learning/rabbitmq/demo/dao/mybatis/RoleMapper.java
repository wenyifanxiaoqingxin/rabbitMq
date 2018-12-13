package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.Role;
import com.learning.rabbitmq.demo.entity.mybatis.RoleExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    long countByExample(RoleExample example);
    List<Role> getRoleById(String id);

}