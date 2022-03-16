package com.jack.demo.dto.book.req;

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
public class BookQueryReq implements Serializable {
    private static final long serialVersionUID = -2864547885814499503L;

    /**
     * 书名
     */
    private String bookname;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer store;
}
