package org.example.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.seata.entries.UserInfo;

@Mapper
public interface UserInfoDao {
    int insertUserInfo(UserInfo userInfo);
}
