package com.dong.interview.mapper;

import com.dong.interview.model.Payment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
public interface PaymentMapper {

    @Select("select id,pay_amount payAmount,state,serial_number serialNumber from t_payment")
    List<Payment> getPayments();
}
