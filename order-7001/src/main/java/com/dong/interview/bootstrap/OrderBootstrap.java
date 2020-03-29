package com.dong.interview.bootstrap;

import com.dong.interview.config.MyRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.dong.interview.controller","com.dong.interview.config"})
@EnableEurekaClient

//指定ribbon调用支付服务的时候使用的负载均衡策略
@RibbonClient(name="payment",configuration = MyRandomRule.class)
public class OrderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(OrderBootstrap.class, args);
    }
}
