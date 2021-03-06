package com.dong.interview.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("payment")
public interface PaymentFeign {

    @GetMapping("/payment/timeout")
    String timeout();
}
