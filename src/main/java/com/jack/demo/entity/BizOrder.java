package com.jack.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bizorder")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BizOrder implements Serializable {
    private static final long serialVersionUID = -814870267822910998L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="bizorderid",referencedColumnName = "id")
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
