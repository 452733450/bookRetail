package com.jack.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/16:23
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Before("com.jack.demo.aspect.SystemArchitecture.inWebLayer()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("Request请求开始");
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "com.jack.demo.aspect.SystemArchitecture.inWebLayer()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("RETURN : " + ret);
    }

    //后置异常通知
    @AfterThrowing("com.jack.demo.aspect.SystemArchitecture.inWebLayer()")
    public void throwss(JoinPoint joinPoint) {
        log.info("方法：{}.{}执行异常 : ", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("com.jack.demo.aspect.SystemArchitecture.inWebLayer()")
    public void after(JoinPoint joinPoint) {
        log.info("方法：{}.{}执行完成 : ", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }
}
