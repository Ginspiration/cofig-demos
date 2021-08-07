package org.example.seata.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "seata-server-addcount")
public interface ConsumerUserCountService {
    @PostMapping("/addUserCount/{userId}/{count}")
    public int addUserCount(@PathVariable Long userId, @PathVariable Long count);
}
