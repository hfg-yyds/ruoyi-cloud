package com.ruoyi.common.core.interfaces;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
@FunctionalInterface
public interface LineHandle {

    /**
     * 行处理器
     * @param list list
     */
    void handle(List<String> list);
}
