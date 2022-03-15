package com.jack.demo.exception;

import com.jack.demo.enums.CommonEnum;
import lombok.Builder;
import lombok.Data;

import java.text.MessageFormat;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/15:03
 */
@Data
@Builder
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer errCode;
    /**
     * 错误信息
     */
    protected String message;

    public BizException(Integer errCode) {
        this.errCode = errCode;
    }

    public BizException(String message) {
        this.errCode = CommonEnum.FAILURE.getCode();
        this.message = message;
    }

    public BizException(String message, Object... params) {
        this.errCode = CommonEnum.FAILURE.getCode();
        this.message = MessageFormat.format(message, params);
    }

    public BizException(CommonEnum CommonEnum) {
        this.errCode = CommonEnum.getCode();
        this.message = CommonEnum.getMessage();
    }

    public BizException(CommonEnum CommonEnum, String message) {
        this.errCode = CommonEnum.getCode();
        this.message = message;
    }

    // 自定义异常
    public BizException(Integer errCode, String message) {
        this.errCode = errCode;
        this.message = message;
    }
}
