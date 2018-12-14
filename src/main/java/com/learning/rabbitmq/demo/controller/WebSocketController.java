package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.entity.mybatis.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fx on 2018/12/11.
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    @RequestMapping("/html")
    public String html(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getUsername());
        return "web";
    }


}
