package com.dong.interview.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
@SpringBootApplication
@ComponentScan(value = {"com.dong.interview.controller","com.dong.interview.service"})
@MapperScan("com.dong.interview.mapper")
public class PaymentBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(PaymentBootstrap.class,args);
    }

}
