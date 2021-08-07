package org.example.seata;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//开启服务发现，自动扫描实现了DiscoveryClient接口的类，使得服务nacos等服务被发现
@EnableFeignClients
@EnableAutoDataSourceProxy//数据源由seata代理,默认CGLIB
public class ProviderUserInfo8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderUserInfo8001.class,args);
    }
}