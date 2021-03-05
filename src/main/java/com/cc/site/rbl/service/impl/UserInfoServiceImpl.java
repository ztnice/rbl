package com.cc.site.rbl.service.impl;

import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.mapper.UserInfoMapper;
import com.cc.site.rbl.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@Service("userInfoService")

public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int insert(UserInfo userInfo) {
        logger.info("插入数据");
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        logger.info("修改数据");
        return userInfoMapper.update(userInfo);
    }

    @Override
    public List<UserInfo> listAllUser() {
        logger.info("查询全部");
        return userInfoMapper.listAll();
    }
}
