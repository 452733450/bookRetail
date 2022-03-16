package com.jack.demo.dto.book.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateReq implements Serializable {
    private static final long serialVersionUID = -2864547885814499503L;

    /**
     * 书名
     */
    @NotNull(message = "书名不能为空")
    private String bookname;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    @DecimalMin("0.01")
    private BigDecimal price;

    /**
     * 库存
     */
    @Min(1)
    @NotNull(message = "库存不能为空")
    private Integer store;
}
