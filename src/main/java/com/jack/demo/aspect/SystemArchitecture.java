package com.jack.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

    @Pointcut("within(com.jack.demo.web.contorller.*)")
    public void inWebLayer() {}

    @Pointcut("within(com.jack.demo.service..*)")
    public void inServiceLayer() {}

    @Pointcut("within(com.jack.demo.dao..*)")
    public void inDataAccessLayer() {}

    @Pointcut("execution(* com.jack.demo.service.*.*(..))")
    public void businessService() {}

    @Pointcut("execution(* com.jack.demo.dao.*.*(..))")
    public void dataAccessOperation() {}

}
