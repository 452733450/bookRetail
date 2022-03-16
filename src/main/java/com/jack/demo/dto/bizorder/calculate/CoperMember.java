package com.jack.demo.dto.bizorder.calculate;

import com.jack.demo.enums.MemberTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 铜牌会员
 */
@Component
public class CoperMember implements CalculateStrategy, InitializingBean {

    @Override
    public BigDecimal calculate(BigDecimal price) {
        return price;
    }

    @Override
    public void afterPropertiesSet() {
        CalculateAdapter.getInstance().map.put(MemberTypeEnum.COPER.getCodeValue(), this);
    }
}
