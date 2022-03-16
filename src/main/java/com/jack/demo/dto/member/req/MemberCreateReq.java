package com.jack.demo.dto.member.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

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
public class MemberCreateReq implements Serializable {
    private static final long serialVersionUID = -3875970543290465797L;

    /**
     * 会员名称
     */
    @NotNull(message = "会员名称不可为空")
    private String membername;

    /**
     * 会员等级（1：铜牌，2：银牌，3：金牌）
     */
    @NotNull(message = "会员等级不可为空")
    @Range(min = 1, max = 3)
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
