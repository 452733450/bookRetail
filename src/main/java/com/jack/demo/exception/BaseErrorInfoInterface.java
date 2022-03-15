package com.jack.demo.exception;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/15:00
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
