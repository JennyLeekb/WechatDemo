package com.lkb.annotion.annotion;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface HandlerType {
    int value();
}
