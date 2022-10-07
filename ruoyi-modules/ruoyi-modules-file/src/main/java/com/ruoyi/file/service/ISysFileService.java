package com.ruoyi.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传接口
 *
 * @author ruoyi
 */
public interface ISysFileService {

    /**
     * 前端文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     */
    String uploadFile(MultipartFile file) throws Exception;

}
