package com.jack.demo.dto.member.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberQueryReq implements Serializable {
    private static final long serialVersionUID = -3875970543290465797L;
    /**
     * 会员名称
     */

    private String membername;

    /**
     * 会员等级（1：金牌，2：银牌，3：铜牌）
     */
    private Integer membertype;

    /**
     * 性别（1：男，女：2）
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;
}
