package com.cc.site.rbl.controller;

import com.alibaba.fastjson.JSON;
import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/all")
    public String listAll(){
       List<UserInfo> list = userInfoService.listAllUser();
       return JSON.toJSONString(list);
    }

    @GetMapping("/insert")
    public void insert(){

        UserInfo sysJob = new UserInfo();
        sysJob.setAccount("a31312");
        sysJob.setEnable(1);
        sysJob.setDeptId("23333");
        sysJob.setName("张三");
        sysJob.setPassword("232134124");
        sysJob.setEmail("aa@bb.com");
        int result = userInfoService.insert(sysJob);
        System.out.println(result);

        logger.info("新增数据成功");


    }

    @GetMapping("/update")
    public void update(){
        UserInfo sysJob = new UserInfo();
        sysJob.setAccount("22313");
        sysJob.setEnable(1);
        sysJob.setEmail("23333");
        int result = userInfoService.update(sysJob);
        System.out.println(result);
        logger.info("修改数据成功");

    }

}
