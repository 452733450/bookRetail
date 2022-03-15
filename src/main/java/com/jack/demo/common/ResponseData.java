package com.jack.demo.common;

import com.jack.demo.enums.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/15:05
 */
@Data
@Builder
@AllArgsConstructor
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 8694155966345453082L;
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回消息
     */
    private String message;

    /**
     * 总记录数
     */
    private long total;

    public static <T> ResponseData<T> success() {
        return ResponseData.<T>builder()
                .code(CommonEnum.SUCCESS.getCode())
                .message(CommonEnum.SUCCESS.getMessage())
                .build();
    }

    public static <T> ResponseData<T> success(T data) {
        return ResponseData.<T>builder()
                .code(CommonEnum.SUCCESS.getCode())
                .message(CommonEnum.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ResponseData<T> error() {
        return ResponseData.<T>builder()
                .code(CommonEnum.FAILURE.getCode())
                .message(CommonEnum.FAILURE.getMessage())
                .build();
    }

    public static <T> ResponseData<T> error(String message) {
        return ResponseData.<T>builder()
                .code(CommonEnum.FAILURE.getCode())
                .message(message)
                .build();
    }

    public static <T> ResponseData<T> paramError(String message) {
        return ResponseData.<T>builder()
                .code(CommonEnum.PARAM_ERROR.getCode())
                .message(message)
                .build();
    }

    public static <T> ResponseData<T> error(Integer code, String message) {
        return ResponseData.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    public ResponseData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(CommonEnum infoCode) {
        this.code = infoCode.getCode();
        this.message = infoCode.getMessage();
    }

    public ResponseData(CommonEnum infoCode, Object... params) {
        this.code = infoCode.getCode();
        this.message = MessageFormat.format(infoCode.getMessage(), params);
    }

    public void setCode(CommonEnum CommonEnum) {
        this.code = CommonEnum.getCode();
        this.message = CommonEnum.getMessage();
    }

    public ResponseData(CommonEnum infoCode, String message, T data) {
        this.code = infoCode.getCode();
        this.message = message;
        this.data = data;
    }

}
