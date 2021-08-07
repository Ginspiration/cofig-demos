package org.example.seata.service.remote;

import org.example.seata.entries.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "seata-server-addinfo")
public interface ConsumerUserInfoService {
    @PostMapping("/addUserInfo")
    public int addUserInfo(UserInfo userInfo);
}
