package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.common.vo.MenuTree;
import com.learning.rabbitmq.demo.entity.mybatis.RoleAuth;
import com.learning.rabbitmq.demo.entity.mybatis.RoleAuthExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleAuthMapper extends Mapper<RoleAuth> {
    long countByExample(RoleAuthExample example);

}