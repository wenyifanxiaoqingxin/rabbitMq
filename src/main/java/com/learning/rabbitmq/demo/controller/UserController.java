package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.common.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2018/12/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getInitUser")
    @ResponseBody
    public AjaxResult getUsers(String userId){

        AjaxResult ajaxResult = new AjaxResult();



        return ajaxResult;
    }

}
