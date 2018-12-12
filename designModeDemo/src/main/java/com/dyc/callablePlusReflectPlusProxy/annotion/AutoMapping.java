package com.dyc.callablePlusReflectPlusProxy.annotion;

import java.lang.annotation.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 19:13
 * @Description:
 */


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoMapping {

    String[] value() default {};
}
