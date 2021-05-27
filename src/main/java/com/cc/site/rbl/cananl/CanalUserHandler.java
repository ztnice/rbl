package com.cc.site.rbl.cananl;

import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@Component
@CanalTable("user_info")
public class CanalUserHandler implements EntryHandler<UserInfo> {

    @Autowired
    private UserInfoService userInfoService;
    @Override
    public void insert(UserInfo userInfo) {
        System.out.println("监听到数据插入");
        userInfoService.getUser(userInfo.getId());
    }

    @Override
    public void update(UserInfo before, UserInfo after) {
        System.out.println("监听到数据修改");
        userInfoService.getUser(after.getId());
    }

    @Override
    public void delete(UserInfo userInfo) {
        System.out.println("监听到数据删除");
        userInfoService.delete(userInfo.getId());
    }
}
