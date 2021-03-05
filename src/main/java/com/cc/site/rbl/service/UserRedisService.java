package com.cc.site.rbl.service;

import com.cc.site.rbl.entity.UserInfo;

import java.util.List;

public interface UserRedisService {

    String USER_KEY = "USER_";


    String putUser(UserInfo userInfo);

    UserInfo getUser(UserInfo userInfo);

    List<UserInfo> listAll();

    String putUser(List<UserInfo> list);

    UserInfo getUser(Integer id);



}
