package com.jack.demo.dto.bizorder.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BizOrderQueryReq implements Serializable {
    private static final long serialVersionUID = -479543404403086830L;

    private Long id;

    /**
     * 订单号
     */
    private String orderno;

    /**
     * 会员id
     */
    private Long memberid;

    /**
     * 总价
     */
    private BigDecimal total;
}
