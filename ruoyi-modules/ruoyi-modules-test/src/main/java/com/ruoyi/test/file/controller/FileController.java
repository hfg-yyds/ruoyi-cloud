package com.ruoyi.test.file.controller;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.file.utils.FieldUtil;
import com.ruoyi.common.file.service.impl.ResolveFileServieImpl;
import com.ruoyi.test.file.entity.FileEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
@RestController
@Slf4j
public class FileController {
    /**
     * 验证文件解析
     */
    @Test
    public void test1() {
        ResolveFileServieImpl resolveFileServie = new ResolveFileServieImpl();
        File file = new File("E:\\JavaCode\\open-project\\RuoYi-Cloud\\ruoyi-modules\\ruoyi-modules-test\\src\\test\\file\\test1.txt");
        resolveFileServie.ResolveTxtFile(file,list->{
            list.forEach(x->{
                List<String> split = StrUtil.split(x, ",");
                FileEntity fileEntity = FieldUtil.get(split, FileEntity.getInstance());
                System.out.println(fileEntity);
            });
        });
    }

}
