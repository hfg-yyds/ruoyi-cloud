package com.ruoyi.common.log.aspect;

/**
 * <p>
 *
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.common.log.aspect.RunEnvironment
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
public class RunEnvironment {

    private static final ThreadLocal<Object[]> threadLocal = new ThreadLocal<>();

    public static Object[] getHeader() {
        return threadLocal.get();
    }

    public static void setHeader(Object[] header) {
        threadLocal.set(header);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
