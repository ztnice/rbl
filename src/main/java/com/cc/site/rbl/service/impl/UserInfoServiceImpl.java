package com.cc.site.rbl.service.impl;

import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.mapper.UserInfoMapper;
import com.cc.site.rbl.service.UserInfoService;
import com.cc.site.rbl.service.UserRedisService;
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

    @Autowired
    private UserRedisService userRedisService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int insert(UserInfo userInfo) {
        logger.info("插入数据");
        int result = userInfoMapper.insert(userInfo);
        //存入redis
        logger.info("存入redis");

        userRedisService.putUser(userInfo);

        return result;

    }

    @Override
    public int update(UserInfo userInfo) {
        logger.info("修改数据");
        int result =  userInfoMapper.update(userInfo);

        userRedisService.putUser(userInfo);
        return result;
    }

    @Override
    public List<UserInfo> listAllUser() {

        logger.info("查询全部");
        return userInfoMapper.listAll();
//        List<UserInfo> userInfos = userRedisService.listAll();
//        if(userInfos == null || userInfos.isEmpty()){
//            List<UserInfo> users = userInfoMapper.listAll();
//            userRedisService.putUser(users);
//            return users;
//        }
//        return userInfos;
    }

    @Override
    public UserInfo getUser(Integer id) {
        UserInfo userInfo = userRedisService.getUser(id);
        if(userInfo == null){
            UserInfo info = userInfoMapper.findById(id);

            if(info != null){
                userRedisService.putUser(info);
            }

            return info;
        }
        return userInfo;
    }


}
