package com.jack.demo.dto.bizorder.calculate;

import com.jack.demo.enums.MemberTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 银牌会员
 */
@Component
public class SilverMember implements CalculateStrategy, InitializingBean {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price.multiply(new BigDecimal(2));
    }

    @Override
    public void afterPropertiesSet() {
        CalculateAdapter.getInstance().map.put(MemberTypeEnum.SILVER.getCodeValue(), this);
    }
}
