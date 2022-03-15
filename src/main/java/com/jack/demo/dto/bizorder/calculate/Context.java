package com.jack.demo.dto.bizorder.calculate;


import java.math.BigDecimal;

public class Context {
    private final CalculateStrategy strategy;

    public Context(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal executeCalculate(BigDecimal price) {
        return strategy.calculate(price);
    }
}
