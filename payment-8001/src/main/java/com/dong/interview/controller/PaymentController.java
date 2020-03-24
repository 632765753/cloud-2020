package com.dong.interview.controller;

import com.dong.interview.model.Payment;
import com.dong.interview.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPayments")
    public List<Payment> getPayments(){
        return paymentService.getPayments();
    }
}
