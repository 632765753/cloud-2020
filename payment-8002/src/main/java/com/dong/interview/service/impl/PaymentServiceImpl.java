package com.dong.interview.service.impl;

import com.dong.interview.mapper.PaymentMapper;
import com.dong.interview.model.Payment;
import com.dong.interview.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<Payment> getPayments() {
        return paymentMapper.getPayments();
    }
}
