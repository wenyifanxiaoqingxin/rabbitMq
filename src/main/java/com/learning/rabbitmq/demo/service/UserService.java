package com.learning.rabbitmq.demo.service;

import com.learning.rabbitmq.demo.common.vo.DataVo;

/**
 * Created by fx on 2018/12/17.
 */
public interface UserService {

    DataVo getListJosn(String userId);
}
