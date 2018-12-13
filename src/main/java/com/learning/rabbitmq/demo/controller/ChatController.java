package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.entity.mybatis.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

/**
 * Created by fx on 2018/12/13.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("/html")
    public String html(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getUsername());
        return "chat/chat";
    }

    @RequestMapping("/msgbox")
    public String msgbox(Model model){
        return "chat/msgbox";
    }
}
