package com.cc.site.rbl.mapper;

import com.cc.site.rbl.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@Repository
public interface UserInfoMapper {

    int insert(UserInfo userInfo);

    int update (UserInfo userInfo);

    List<UserInfo> listAll();

    UserInfo findById(Integer Id);
}
