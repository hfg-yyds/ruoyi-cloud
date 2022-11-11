package com.ruoyi.common.file.service;

import com.ruoyi.common.core.interfaces.LineHandle;

import java.io.File;

/**
 * <p>
 *  中小文件解析Service
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
public interface ResolveFileServie {

    /**
     * 按行解析文件
     * @param file 待处理文件
     * @param lineHandle 行处理器
     */
    void ResolveTxtFile(File file, LineHandle lineHandle);

}
