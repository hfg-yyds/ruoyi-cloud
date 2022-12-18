package com.ruoyi.common.file.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.ruoyi.common.core.exception.busi.enums.FileException;
import com.ruoyi.common.file.interfaces.LineHandle;
import com.ruoyi.common.file.service.ResolveFileServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;

/**
 * <p>
 *  文件解析服务
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
@Slf4j
@Service
public class ResolveFileServieImpl implements ResolveFileServie {

    /**
     * 待处理行最大数量
     */
    public static final int LineSize = 1000;

    /**
     * 按行解析文件
     * 新起一个事务,保证文件处理与业务事务分离开来
     *
     * @param file file
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void ResolveTxtFile(File file, LineHandle lineHandle) {
        List<String> list = ListUtil.toList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String line;
            while ((line= br.readLine())!=null) {
                list.add(line);
                if (list.size()== LineSize) {
                    lineHandle.handle(list);
                }
            }
            lineHandle.handle(list);
        } catch (Exception e) {
            log.error("文件解析异常"+e);
            throw FileException.FILE_PARSE_EXCEPTION.exception();
        }
    }


}
