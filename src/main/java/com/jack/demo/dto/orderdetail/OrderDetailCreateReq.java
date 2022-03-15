package com.jack.demo.dto.orderdetail;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class OrderDetailCreateReq implements Serializable {
    private static final long serialVersionUID = -6657795830418908498L;

    /**
     * 书籍id
     */
    @NotNull(message = "书籍id不能为空")
    private Long bookid;

    /**
     * 购买数量
     */
    @Min(1)
    private Integer num;
}
