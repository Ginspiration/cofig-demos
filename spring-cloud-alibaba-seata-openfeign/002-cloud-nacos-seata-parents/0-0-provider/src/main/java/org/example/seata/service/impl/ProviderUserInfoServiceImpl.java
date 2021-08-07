package org.example.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.seata.dao.UserInfoDao;
import org.example.seata.entries.UserInfo;
import org.example.seata.service.ProviderUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ProviderUserInfoServiceImpl implements ProviderUserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional
    public int addUserInfo(UserInfo userInfo) {
        int result = userInfoDao.insertUserInfo(userInfo);
        if ( result > 0) {
            int userId = userInfo.getId().intValue();
            log.info("userId : "+userId);
            return userId;
        }
        return 0;
    }
}
