package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.FriendGroup;
import com.learning.rabbitmq.demo.entity.mybatis.FriendGroupExample;
import tk.mybatis.mapper.common.Mapper;

public interface FriendGroupMapper extends Mapper<FriendGroup> {
    long countByExample(FriendGroupExample example);
}