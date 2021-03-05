package com.cc.site.rbl.service;

import com.cc.site.rbl.entity.UserInfo;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
public interface UserInfoService {

    int insert(UserInfo userInfo);
    int update(UserInfo userInfo);
    List<UserInfo> listAllUser();
}
