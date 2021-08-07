package org.example.seata.controller;

import org.example.seata.service.ProviderUserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private ProviderUserCountService providerUserCountService;

    @PostMapping("/addUserCount/{userId}/{count}")
    public int addUserCount(@PathVariable Long userId,@PathVariable Long count){
        return providerUserCountService.addUserCount(userId,count);
    }
}
