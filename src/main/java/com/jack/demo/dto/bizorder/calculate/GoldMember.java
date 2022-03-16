package com.jack.demo.dto.bizorder.calculate;

import com.jack.demo.enums.MemberTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 金牌会员
 */
@Component
public class GoldMember implements CalculateStrategy, InitializingBean {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal(3));
    }

    @Override
    public void afterPropertiesSet() {
        CalculateAdapter.getInstance().map.put(MemberTypeEnum.GOLD.getCodeValue(), this);
    }
}
