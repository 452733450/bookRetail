package com.jack.demo.dto.bizorder.calculate;

import java.math.BigDecimal;

/**
 * 金牌会员
 */
public class GoldMember implements CalculateStrategy {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal(3));
    }
}
