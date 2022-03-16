package com.jack.demo.dto.bizorder.calculate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculateAdapter {

    Map<Integer, CalculateStrategy> map = new HashMap<>();

    private CalculateAdapter() {

    }

    private static class Holder {
        private static final CalculateAdapter instance = new CalculateAdapter();
    }

    public static CalculateAdapter getInstance() {
        return Holder.instance;
    }

    public BigDecimal executeCalculate(BigDecimal price, Integer strategy) {
        return map.get(strategy).calculate(price);
    }
}
