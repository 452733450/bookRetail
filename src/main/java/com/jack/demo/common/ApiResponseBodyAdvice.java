package com.jack.demo.common;

import com.jack.demo.annotation.ResponseWrapable;
import com.jack.demo.enums.CommonEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2020/11/06/16:00
 */
@ControllerAdvice(basePackages = {"com.manager.web"})
@Slf4j
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ResponseWrapable at = returnType.getMethodAnnotation(ResponseWrapable.class);
        return at != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", CommonEnum.SUCCESS.getCode());
        ret.put("data", body);
        ret.put("message", CommonEnum.SUCCESS.getMessage());

        return ret;
    }
}
