package com.jack.demo.dto.bizorder.calculate;


import java.math.BigDecimal;

public interface CalculateStrategy {

    BigDecimal calculate(BigDecimal price);
}
