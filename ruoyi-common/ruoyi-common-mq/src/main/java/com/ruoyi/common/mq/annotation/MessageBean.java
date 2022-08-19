package com.ruoyi.common.mq.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.common.mq.MessageQueue
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MessageBean {


    @AliasFor(annotation = Component.class)
    String value() default "";

}
