package com.jack.demo.dto.orderdetail.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailBO implements Serializable {
    private static final long serialVersionUID = -6657795830418908498L;

    /**
     * 书籍id
     */
    @NotNull(message = "书籍id不能为空")
    private Long bookid;

    /**
     * 购买数量
     */
    @NotNull(message = "购买数量不能为空")
    @Min(1)
    private Integer num;

    /**
     * 购买单价
     */
    @NotNull(message = "购买单价不能为空")
    private BigDecimal price;
}
