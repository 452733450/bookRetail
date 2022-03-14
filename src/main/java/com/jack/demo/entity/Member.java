package com.jack.demo.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="MEMBER")
@Data
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 会员名称
     */
    @Column
    private String memberName;

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
    private Integer isDeleted;

    /**
     * 更新时间
     */
    @Column
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column
    private Date createTime;
}
