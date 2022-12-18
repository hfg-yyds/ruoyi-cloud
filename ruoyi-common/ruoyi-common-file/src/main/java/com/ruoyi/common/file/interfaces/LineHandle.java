package com.ruoyi.common.file.interfaces;

import java.util.List;

/**
 * <p>
 *  行处理器
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
