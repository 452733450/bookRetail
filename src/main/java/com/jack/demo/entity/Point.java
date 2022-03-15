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
@Table(name = "point")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Point implements Serializable {
    private static final long serialVersionUID = -7352672302226828462L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员id
     */
    private Long memberid;

    /**
     * 总积分
     */
    private BigDecimal total;

    /**
     * 是否已删除(1:是，0：否)
     */
    @Column
    private Integer isdeleted;

    /**
     * 更新时间
     */
    @Column
    private Date updatetime;

    /**
     * 创建时间
     */
    @Column
    private Date createtime;
}
