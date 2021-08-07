package org.example.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.seata.entries.UserInfo;

@Mapper
public interface UserCountDao {
    int insertUserInfo(UserInfo userInfo);
    int insertUserCount(@Param("_id")Long id,@Param("_count")Long count);
}
