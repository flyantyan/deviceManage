package com.nuc.device.base.poi.annotation;

import java.lang.annotation.*;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:0:35
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExcelColumnName {
    public String value() default "";
}
