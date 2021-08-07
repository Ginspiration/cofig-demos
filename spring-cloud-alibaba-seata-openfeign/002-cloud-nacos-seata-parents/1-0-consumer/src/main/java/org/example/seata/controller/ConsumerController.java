package org.example.seata.controller;


import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.example.seata.entries.UserInfo;
import org.example.seata.service.AddUserService;
import org.example.seata.service.remote.ConsumerUserCountService;
import org.example.seata.service.remote.ConsumerUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@Slf4j
public class ConsumerController {
    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    private AddUserService addUserService;
    /**
     * 新的账户每个人发100 0000 $
     */
    @GetMapping("/newUser/{name}")
    @GlobalTransactional
    public Object addUser(@PathVariable String name){
        return addUserService.addUser(name);
    }

}
