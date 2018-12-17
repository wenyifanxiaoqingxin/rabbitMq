package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.common.vo.GroupVo;
import com.learning.rabbitmq.demo.entity.mybatis.Group;
import com.learning.rabbitmq.demo.entity.mybatis.GroupExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GroupMapper extends Mapper<Group> {
    long countByExample(GroupExample example);
    List<GroupVo> getGroup(String userId);
}