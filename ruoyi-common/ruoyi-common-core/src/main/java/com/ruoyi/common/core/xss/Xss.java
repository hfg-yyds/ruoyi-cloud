package com.ruoyi.common.core.xss;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义xss校验注解
 *
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {XssValidator.class})
public @interface Xss {

    /**
     * Xss信息
     * @return String
     */
    String message() default "不允许任何脚本运行";

    /**
     * 分组
     * @return Class
     */
    Class<?>[] groups() default {};

    /**
     * 有效载荷类型
     * @return Payload以及子类
     */
    Class<? extends Payload>[] payload() default {};

}
