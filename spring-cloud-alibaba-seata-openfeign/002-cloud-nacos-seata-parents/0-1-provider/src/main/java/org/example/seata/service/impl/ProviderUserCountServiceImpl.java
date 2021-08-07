package org.example.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.seata.dao.UserCountDao;
import org.example.seata.service.ProviderUserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ProviderUserCountServiceImpl implements ProviderUserCountService {

    @Autowired
    private UserCountDao userCountDao;


    @Override
    @Transactional
    public int addUserCount(Long userId, Long count) {
        return userCountDao.insertUserCount(userId,count);
    }
}
