package com.ruoyi.common.core.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 按行解析文件实体属性顺序
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-28
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface FieldOrder {
    /**
     * 属性顺序
     * @return  int
     */
    int order() default 0;
}
