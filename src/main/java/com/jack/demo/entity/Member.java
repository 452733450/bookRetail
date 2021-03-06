package com.jack.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 1743432154663277030L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员名称
     */
    @Column
    private String membername;

    /**
     * 会员等级（1：金牌，2：银牌，3：铜牌）
     */
    @Column
    private Integer membertype;

    /**
     * 性别（1：男，女：2）
     */
    @Column
    private Integer sex;

    /**
     * 年龄
     */
    @Column
    private Integer age;

    /**
     * 手机号码
     */
    @Column
    private String mobile;

    /**
     * 邮箱
     */
    @Column
    private String email;

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
