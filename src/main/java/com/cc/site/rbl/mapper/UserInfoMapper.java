package com.cc.site.rbl.mapper;

import com.cc.site.rbl.entity.UserInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author haozt
 * @since 2021/3/5
 */
@Repository
public interface UserInfoMapper {

    int insert(UserInfo userInfo);

    int insertList(List<UserInfo> list);

    int update (UserInfo userInfo);

    int delete(Integer id);

    List<UserInfo> listAll();

    UserInfo findById(Integer Id);
}
