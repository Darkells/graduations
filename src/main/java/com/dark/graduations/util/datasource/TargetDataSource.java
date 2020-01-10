package com.dark.graduations.util.datasource;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    String value() default CommonConstant.SLAVE_DATASOURCE;
}
