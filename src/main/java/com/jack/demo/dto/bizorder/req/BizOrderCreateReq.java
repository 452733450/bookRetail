package com.jack.demo.dto.bizorder.req;

import com.jack.demo.dto.orderdetail.bo.OrderDetailBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BizOrderCreateReq implements Serializable {
    private static final long serialVersionUID = -479543404403086830L;

    /**
     * 会员id
     */
    @NotNull(message = "会员id不能为空")
    private Long memberid;

    @NotEmpty(message = "购买信息不能为空")
    List<@Valid OrderDetailBO> orderDetailBOList;
}
