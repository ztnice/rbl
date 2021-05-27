package com.cc.site.rbl.service.impl;

import com.alibaba.fastjson.JSON;
import com.cc.site.rbl.entity.UserInfo;
import com.cc.site.rbl.redis.util.JedisUtil;
import com.cc.site.rbl.service.UserRedisService;
import com.cc.site.rbl.util.MapUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRedisServiceImpl implements UserRedisService {
    @Override
    public String putUser(UserInfo userInfo) {

        return JedisUtil.set(USER_KEY + userInfo.getId() , JSON.toJSONString(userInfo));

//        return JedisUtil.hmset(USER_KEY + userInfo.getId(), MapUtil.beanToMap(userInfo));

    }

    @Override
    public UserInfo getUser(UserInfo userInfo) {
        String value = JedisUtil.get(USER_KEY + userInfo.getId());

        Map<String,Object> map = (Map)JSON.parse(value);

        return  MapUtil.mapToObject(map,UserInfo.class);


    }

    @Override
    public List<UserInfo> listAll() {
        Set<String> keys = JedisUtil.keys(USER_KEY+"*");

        Optional<Set<String>> optionalStrings = Optional.of(keys);
        List<UserInfo> userInfos = new ArrayList<>();
        optionalStrings.ifPresent( optionals ->{
            optionals.forEach(o ->{
                String v = JedisUtil.get(o);
                Map<String,Object> map = (Map)JSON.parse(v);

                UserInfo userInfo  = MapUtil.mapToObject(map,UserInfo.class);
                userInfos.add(userInfo);
            });
        });
        return userInfos;
    }

    @Override
    public String putUser(List<UserInfo> list) {
        Optional<List<UserInfo>> optionalList = Optional.of(list);
        optionalList.ifPresent(infoList  -> {
           infoList.forEach(this :: putUser);
        });
        return "OK";
    }

    @Override
    public UserInfo getUser(Integer id) {
        String value = JedisUtil.get(USER_KEY + id);
        Map<String,Object> map = (Map)JSON.parse(value);
        return  MapUtil.mapToObject(map,UserInfo.class);
    }



}
