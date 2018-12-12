package com.learning.rabbitmq.demo.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fx on 2018/12/12.
 */
@Configuration
public class ShiroConfig {

    private Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //此处设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/notlogin");
        //无权限时跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //
        shiroFilterFactoryBean.setSuccessUrl("/home");

        //拦截器设置
        Map<String,String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/font/**", "anon");
//        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainMap.put("/images/**", "anon");
        //游客访问
        filterChainMap.put("/guest/**","anon");
        //用户，需要角色权限"user"
        filterChainMap.put("/user/**","roles[user]");
        //管理员 权限admin
        filterChainMap.put("/admin/**","roles[admin]");
        //登录接口开发
        filterChainMap.put("/login","anon");
        filterChainMap.put("/loginIn","anon");
        //拦截其他接口,要放在最后，不然会拦截所有接口
        filterChainMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        logger.info("******shiro 拦截器工厂注入成功******");
        return shiroFilterFactoryBean;

    }
    /**
     * 自定义身份认证 realm;
     * <p>
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm(){
        return new CustomRealm();
    }
    //注入SecurityManager
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }
}
