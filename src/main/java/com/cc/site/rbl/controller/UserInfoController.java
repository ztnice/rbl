package com.cc.site.rbl.controller;

import com.alibaba.fastjson.JSON;
import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.*;

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

    private final AmqpTemplate amqpTemplate;


    public UserInfoController(UserInfoService userInfoService, AmqpTemplate amqpTemplate) {
        this.userInfoService = userInfoService;
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/all")
    public String listAll(){
       List<UserInfo> list = userInfoService.listAllUser();
       return JSON.toJSONString(list);
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") Integer id){
        UserInfo info = userInfoService.getUser(id);
        return JSON.toJSONString(info);

    }

    @PostMapping("/insert")
    public void insert(){

        new Thread(this::insertUser).start();

        new Thread(()->{
            for(int i = 0 ; i < 50000; i++){
                amqpTemplate.convertAndSend("exchange","topic.user",user());
            }
        }).start();

        new Thread(()->{
            for(int i = 0 ; i < 5000; i++){
                insertUser();
            }
        }).start();

        new Thread(()->{
            for(int i = 0 ; i < 50000; i++){
                amqpTemplate.convertAndSend("topic",user());
            }
        }).start();



    }



    private void insertUser(){
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



    private UserInfo user(){
        UserInfo sysJob = new UserInfo();
        sysJob.setAccount("momo");
        sysJob.setEnable(1);
        sysJob.setDeptId("23333");
        sysJob.setName("test");
        sysJob.setPassword("232134124");
        sysJob.setEmail("aa@bb.com");
        return sysJob;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id){
        UserInfo sysJob = new UserInfo();
        sysJob.setAccount("22313");
        sysJob.setEnable(1);
        sysJob.setEmail("2332312333");
        sysJob.setId(id);
        int result = userInfoService.update(sysJob);
        System.out.println(result);
        logger.info("修改数据成功");
        return JSON.toJSONString(result);

    }

}
