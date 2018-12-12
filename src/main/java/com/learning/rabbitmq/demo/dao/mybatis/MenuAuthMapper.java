package com.learning.rabbitmq.demo.dao.mybatis;

import com.learning.rabbitmq.demo.common.vo.MenuTree;
import com.learning.rabbitmq.demo.entity.mybatis.MenuAuth;
import com.learning.rabbitmq.demo.entity.mybatis.MenuAuthExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuAuthMapper extends Mapper<MenuAuth> {
    long countByExample(MenuAuthExample example);

    List<MenuTree> selectMenu(@Param("id") String id, @Param("userId") String userId);

}