package com.dyc.annotation;

import java.lang.annotation.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/14 16:58
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoRecord {

    String[] value() default {};

    boolean state() default true;

    String[] timeAliasName() default {};
}
