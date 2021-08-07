package org.example.seata.service.impl;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.example.seata.controller.ConsumerController;
import org.example.seata.entries.UserInfo;
import org.example.seata.service.AddUserService;
import org.example.seata.service.remote.ConsumerUserCountService;
import org.example.seata.service.remote.ConsumerUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class AddUserServiceImpl implements AddUserService {

    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerUserInfoService consumerUserInfoService;
    @Autowired
    private ConsumerUserCountService consumerUserCountService;

    //private Lock lock = new ReentrantLock();

    @Override
    @Transactional
    public String addUser(String name) {
        logger.info("seata分布式事务Id:{}", RootContext.getXID());
        //lock.lock();
        try {
            int userId = consumerUserInfoService.addUserInfo(new UserInfo(null, name));
            //log.info("userId : "+userId);
            int result = consumerUserCountService.addUserCount((long) userId, 1000000L);
            //log.info("成功条数 ：" +result);
            if ("e".equals(name)) {
                throw new RuntimeException("手动异常");
            }
            return "创建新的用户，并发账100 0000刀🔪";
        }catch (Exception e) {
            // TODO: handle exception
            logger.info("载入事务id进行回滚");
            try {
                GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            } catch (TransactionException transactionException) {
                transactionException.printStackTrace();
            }
            return "创建失败";
        } finally {
            //lock.unlock();
        }
    }
}
