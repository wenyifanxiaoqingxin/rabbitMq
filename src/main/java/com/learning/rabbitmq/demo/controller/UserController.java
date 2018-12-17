package com.learning.rabbitmq.demo.controller;

import com.learning.rabbitmq.demo.common.vo.AjaxResult;
import com.learning.rabbitmq.demo.common.vo.DataVo;
import com.learning.rabbitmq.demo.common.vo.InitResultVo;
import com.learning.rabbitmq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2018/12/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @RequestMapping("/getInitUser")
    @ResponseBody
    public InitResultVo getUsers(String userId){
        InitResultVo ajaxResult = new InitResultVo();

        try{
            DataVo dataVo =service.getListJosn(userId);
            ajaxResult.setCode(AjaxResult.SUCCESS);
            ajaxResult.setData(dataVo);
            ajaxResult.setMsg("成功");
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(AjaxResult.FAIL);
            ajaxResult.setMsg("失败");
        }



        return ajaxResult;
    }

}
