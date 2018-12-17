package com.learning.rabbitmq.demo.config.shiro;

import com.learning.rabbitmq.demo.dao.mybatis.MenuAuthMapper;
import com.learning.rabbitmq.demo.dao.mybatis.RoleMapper;
import com.learning.rabbitmq.demo.dao.mybatis.UserMapper;
import com.learning.rabbitmq.demo.entity.mybatis.MenuAuth;
import com.learning.rabbitmq.demo.entity.mybatis.Role;
import com.learning.rabbitmq.demo.entity.mybatis.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fx on 2018/12/12.
 */
public class CustomRealm extends AuthorizingRealm{

    private Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    private UserMapper userMapper;
    private MenuAuthMapper menuAuthMapper;
    private RoleMapper roleMapper;

    @Autowired
    private void setUserMapper(UserMapper userMapper,MenuAuthMapper menuAuthMapper,RoleMapper roleMapper){
        this.userMapper = userMapper;
        this.menuAuthMapper = menuAuthMapper;
        this.roleMapper = roleMapper;
    }



    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("----身份认证----");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.getUser(token.getUsername());
        if(user==null){
            throw new AccountException("不存在此用户");
        }
        String password = user.getPassword();
        if(StringUtils.isEmpty(password)){
            throw new AccountException("不存在此用户");
        }else if(!password.equals(new String(token.getPassword()))){
            throw new IncorrectCredentialsException("密码不正确");
        }
        logger.info("----身份认证成功----");
        return new SimpleAuthenticationInfo(user,password,getName());
    }


    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("----权限认证----");
        User user  = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = roleMapper.getRoleById(user.getId());
        List<String> ids = new ArrayList<>();
        for(int i=0;i<roles.size();i++){
            simpleAuthorizationInfo.addRole(roles.get(i).getRole());
            ids.add(roles.get(i).getId());
        }

        List<MenuAuth> menuAuths = menuAuthMapper.getAuthById(ids);
        for(int j=0;j<roles.size();j++){
            simpleAuthorizationInfo.addStringPermission(menuAuths.get(j).getAuthName());
        }

        return simpleAuthorizationInfo;
    }
}
