package com.jack.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orderdetail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 3448071823735527269L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    private Long bizorderid;

    /**
     * 订单号
     */
    private String orderno;

    /**
     * 会员id
     */
    private Long memberid;

    /**
     * 书籍id
     */
    private Long bookid;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 购买单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal total;

    /**
     * 是否已删除(1:是，0：否)
     */
    private Integer isdelete;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 创建时间
     */
    private Date createtime;
}
