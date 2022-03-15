package com.jack.demo.dto.bizorder.calculate;

import java.math.BigDecimal;

/**
 * 银牌会员
 */
public class SilverMember implements CalculateStrategy{

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal(2));
    }
}
