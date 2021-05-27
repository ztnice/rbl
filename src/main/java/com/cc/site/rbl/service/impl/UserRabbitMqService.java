package com.cc.site.rbl.service.impl;

import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.service.UserInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.Contended;

@Contended
@Service
public class UserRabbitMqService {

    @Autowired
    private UserInfoService userInfoService;

    @RabbitListener(queues = "topic.user")
//    @RabbitHandler
    public void insertUser(UserInfo userInfo){
        userInfoService.insert(userInfo);
    }
}
