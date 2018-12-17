package com.learning.rabbitmq.demo.service.impl;

import com.learning.rabbitmq.demo.common.vo.DataVo;
import com.learning.rabbitmq.demo.common.vo.FriendVo;
import com.learning.rabbitmq.demo.common.vo.GroupVo;
import com.learning.rabbitmq.demo.dao.mybatis.FriendGroupMapper;
import com.learning.rabbitmq.demo.dao.mybatis.GroupMapper;
import com.learning.rabbitmq.demo.dao.mybatis.SubGroupMapper;
import com.learning.rabbitmq.demo.dao.mybatis.UserMapper;
import com.learning.rabbitmq.demo.entity.mybatis.Group;
import com.learning.rabbitmq.demo.entity.mybatis.User;
import com.learning.rabbitmq.demo.service.UserService;
import com.learning.rabbitmq.demo.vo.UserInformationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fx on 2018/12/17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private FriendGroupMapper friendGroupMapper;

    @Autowired
    private SubGroupMapper subGroupMapper;

    public DataVo getListJosn(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        UserInformationVo userInformationVo = new UserInformationVo();
        userInformationVo.setUsername(user.getUsername());
        userInformationVo.setId(user.getId());
        userInformationVo.setAvatar(user.getAvatar());
        userInformationVo.setStatus(user.getStatus());
        userInformationVo.setSign(user.getSign());
        DataVo dataVo = new DataVo();
        dataVo.setMine(userInformationVo);
        List<FriendVo> friendVos = userMapper.getListJosn(userId);
        dataVo.setFriend(friendVos);

        List<GroupVo> groups = groupMapper.getGroup(userId);
        dataVo.setGroup(groups);
        return dataVo;
    }
}
