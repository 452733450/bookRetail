package com.jack.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:58
 */
@Getter
@AllArgsConstructor
public enum CommonEnum {
    SUCCESS("请求成功", 1008),
    FAILURE("请求失败", 1009),
    INVALID("token失效", 1010),
    PARAM_ERROR("参数{0}错误", 1011),
    PARAMS_ERROR("参数错误", 1011),
    COMMON_ERROR("系统内部异常，请联相关系技术人员", 1009),
    ;

    /**
     * 描述
     */
    private String message;
    /**
     * 返回码
     */
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
