package com.learning.rabbitmq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fx on 2018/12/11.
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    public String html(){
        return "web";
    }

}
