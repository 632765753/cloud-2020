package com.dong.interview.controller;

import com.dong.interview.model.Payment;
import com.dong.interview.service.PaymentService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/getPayments")
    public List<Payment> getPayments(){
        return paymentService.getPayments();
    }


    @GetMapping("/payment/getServerPort")
    public String getServerPort(){
        return port;
    }

    @GetMapping("/payment/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}
