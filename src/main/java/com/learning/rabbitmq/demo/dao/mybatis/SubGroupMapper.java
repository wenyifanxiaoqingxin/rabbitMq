package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.entity.mybatis.SubGroup;
import com.learning.rabbitmq.demo.entity.mybatis.SubGroupExample;
import tk.mybatis.mapper.common.Mapper;

public interface SubGroupMapper extends Mapper<SubGroup> {
    long countByExample(SubGroupExample example);
}