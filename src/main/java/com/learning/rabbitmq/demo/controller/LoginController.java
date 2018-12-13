package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.common.vo.AjaxResult;
import com.learning.rabbitmq.demo.entity.mybatis.User;
import com.learning.rabbitmq.demo.service.MenuAuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Created by fx on 2018/12/12.
 */

@Controller
public class LoginController {

    @Autowired
    private MenuAuthService menuAuthService;

    @RequestMapping("/login")
    public String html(){
        return "login";
    }

    @RequestMapping("/notlogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginIn")
    @ResponseBody
    public AjaxResult loginIn(String username, String password,HttpServletRequest request){
        AjaxResult result = new AjaxResult();
        try{
            Subject subject = SecurityUtils.getSubject();
            //认证前准备令牌
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            //执行登陆
            subject.login(usernamePasswordToken);

            HttpSession session = request.getSession();
            session.setAttribute("user",SecurityUtils.getSubject().getPrincipal());
            System.out.println("session放入："+session.getAttribute("user"));
            result.setCode(AjaxResult.SUCCESS);
            result.setMessage("成功");
        }catch (UnknownAccountException e){
            result.setCode(AjaxResult.SUCCESS);
            //用户名不存在
            result.setMessage("0");
        }catch (IncorrectCredentialsException e){
            result.setCode(AjaxResult.SUCCESS);
            //密码错误
            result.setMessage("1");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(AjaxResult.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model){
        String ctx = request.getContextPath();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String treeHtml = menuAuthService.menuTree(ctx,user.getId());
        model.addAttribute("tree", treeHtml);
        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getUsername());
        return "home";
    }
}
