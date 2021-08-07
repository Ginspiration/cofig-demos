package org.example.seata.controller;

import org.example.seata.entries.UserInfo;
import org.example.seata.service.ProviderUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderUserInfoController {

    @Autowired
    private ProviderUserInfoService providerUserInfoService;

    @PostMapping("/addUserInfo")
    public int addUserInfo(@RequestBody UserInfo userInfo){
        return providerUserInfoService.addUserInfo(userInfo);
    }
}
