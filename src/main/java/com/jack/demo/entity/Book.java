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
@Table(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = -2338576718053818431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 是否已删除(1:是，0：否)
     */
    private Integer isdeleted;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 创建时间
     */
    private Date createtime;
}
