package com.jack.demo.dto.bizorder.calculate;

import java.math.BigDecimal;

/**
 * 牌会员
 */
public class CoperMember implements CalculateStrategy{

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price;
    }
}
