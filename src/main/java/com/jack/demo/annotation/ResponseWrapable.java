package com.jack.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2020/11/06/15:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface ResponseWrapable {

}
