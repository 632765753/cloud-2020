package com.dong.interview.controller;

import com.dong.interview.service.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {
    /**
     * 提供url，使用restTemplate调用服务
     */
    public static final String PAYMENT_URL="http://localhost:8001";

    /**
     * 提供服务名称，并将服务都注册到注册中心后，通过restTemplate+ribbon+eureka来实现服务的调用
     */
    public static final String PAYMENT_APPLICATION_NAME="http://payment";

    /**
     * 使用restTemplate来实现服务间的调用，需要手动new出来，放到spring容器里边；
     * 第一种调用方式就是通过ip+port+具体的接口url
     * 第二种抵用方式就是通过服务名称+具体的接口url，这种调用方式要配置注解中心来实现。
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用声明式的feign接口调用服务
     */
    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/order/getPayments")
    public List<Object> getPayments(){
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPayments", Object.class);
        return (List<Object>) forEntity.getBody();
    }

    @GetMapping("/order/getServerPort")
    public String getPaymentServerPort(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity(PAYMENT_APPLICATION_NAME + "/payment/getServerPort", String.class);
        return  forEntity.getBody();
    }

    @GetMapping("/order/timeout")
    public String timeout(){
        String timeout = paymentFeign.timeout();
        return timeout;
    }
}
