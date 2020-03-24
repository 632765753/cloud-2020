package com.dong.interview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description
 * @Author dengdongdong
 * @Date 2020/3/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private Long id;
    private String serialNumber;
    private Integer state;
    private BigDecimal payAmount;
}
