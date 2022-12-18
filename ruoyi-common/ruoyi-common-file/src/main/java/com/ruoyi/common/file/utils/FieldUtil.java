package com.ruoyi.common.file.utils;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.core.annotation.FieldOrder;
import com.ruoyi.common.file.interfaces.OrderEntity;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-28
 */
@Slf4j
public class FieldUtil {

    /**
     * 按行解析文件成List<String> 可以通过此方法把值存入到对象当中去
     * @param list list
     * @param instance instance
     * @param <T> T
     * @return T
     */
    public static  <T extends OrderEntity> T get(List<String> list, T instance)  {
        try {
            Class<? extends OrderEntity> aClass = instance.getClass();
            Field[] fields = aClass.getDeclaredFields();
            Assert.isTrue(list.size()==fields.length,"属性值存在问题");
            for (Field field : fields) {
                field.setAccessible(true);
                int order = field.getAnnotation(FieldOrder.class).order();
                field.set(instance, StrUtil.trim(list.get(order)));
            }
        }catch (Exception e) {
            log.error("属性转换:,",e);
        }
        return instance;
    }

}
