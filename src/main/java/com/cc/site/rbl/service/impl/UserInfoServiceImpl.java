package com.cc.site.rbl.service.impl;

import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.mapper.UserInfoMapper;
import com.cc.site.rbl.service.UserInfoService;
import com.cc.site.rbl.util.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haozt
 * @since 2021/3/5
 */

@CacheConfig(cacheNames = "user_info")
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

    @CacheEvict(key ="#id" )
    @Override
    public int delete(Integer id) {
        return userInfoMapper.delete(id);
    }

    @Override
    public void insertList(List<UserInfo> userInfos) {

        logger.info("批量数据插入开始");
        Executor executor = Executors.newFixedThreadPool(10);
        List<List<UserInfo>> infos = ListUtil.splitList(userInfos);
        for(List<UserInfo> infoList : infos){
            ((ExecutorService) executor).submit(() -> userInfoMapper.insertList(infoList));
        }
        logger.info("批量数据插入结束(异步)");
        ((ExecutorService) executor).shutdown();
    }

    @Override
    public List<UserInfo> listAllUser() {
        logger.info("查询全部");
        return userInfoMapper.listAll();
    }




    @Cacheable(key = "#key")
    @Override
    public List<UserInfo> listAllUser(String key) {
        logger.info("查询全部");
        return listAllUser();
    }

    @Cacheable(key = "#id")
    @Override
    public UserInfo getUser(Integer id) {
        return userInfoMapper.findById(id);

    }


}
