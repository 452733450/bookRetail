package com.jack.demo.exception;

import com.jack.demo.common.ResponseData;
import com.jack.demo.enums.CommonEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String TRACE_ID = "traceId";

    @ExceptionHandler()
    public ResponseData<String> defaultErrorHandler(Exception e) {
        log.error("捕获业务异常：", e);
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            if (CommonEnum.COMMON_ERROR.getCode().equals(bizException.getErrCode())) {
                if (bizException.getMessage().equals(CommonEnum.COMMON_ERROR.getMessage())) {
                    return new ResponseData<>(bizException.getErrCode(), bizException.getMessage() + "。错误代码:" + MDC.get(TRACE_ID));
                }
                return new ResponseData<>(bizException.getErrCode(), bizException.getMessage());
            }
            return new ResponseData<>(bizException.getErrCode(), e.getMessage());
        }
        return new ResponseData<>(CommonEnum.FAILURE.getCode(), e.getMessage() + "。错误代码:" + MDC.get(TRACE_ID));
    }


    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseData<String> handleException(HttpRequestMethodNotSupportedException e) {
        log.error("捕获业务异常{},{}", CommonEnum.FAILURE.getCode(), "不支持的请求方法", e);
        return new ResponseData<>(CommonEnum.FAILURE.getCode(), "不支持的请求方法");
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseData<String> exceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        log.error("捕获业务异常{},{}", CommonEnum.FAILURE.getCode(), message, e);
        return new ResponseData<>(CommonEnum.FAILURE.getCode(), message);
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ResponseData<String> validationExceptionHandler(BindException e) {
        String message = "参数不合法";
        if (!e.getBindingResult().getFieldErrors().isEmpty()) {
            message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        }
        log.error("捕获业务异常{},{}", CommonEnum.FAILURE.getCode(), message, e);
        return new ResponseData<>(CommonEnum.FAILURE.getCode(), message);
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseData<String> readableException(HttpMessageNotReadableException e) {
        log.error("捕获业务异常:{}", CommonEnum.PARAMS_ERROR.getMessage(), e);
        return ResponseData.error(CommonEnum.PARAMS_ERROR.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseData<String> violationException(ConstraintViolationException e) {
        String msg = "参数异常";
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            msg = constraintViolation.getMessage();
            break;
        }
        log.error("捕获业务异常：{}，{}", CommonEnum.PARAMS_ERROR.getMessage(), msg, e);
        return new ResponseData<>(CommonEnum.PARAMS_ERROR.getCode(), msg);
    }

    /**
     * 缺少请求参数异常处理
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseData<String> handleException(MissingServletRequestParameterException e) {
        log.error("捕获业务异：{}", CommonEnum.PARAMS_ERROR.getMessage(), e);
        return new ResponseData<>(CommonEnum.PARAMS_ERROR);
    }
}
