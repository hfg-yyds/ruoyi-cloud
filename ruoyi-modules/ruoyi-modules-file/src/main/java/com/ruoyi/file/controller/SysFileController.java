package com.ruoyi.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.file.FileUtils;
import com.ruoyi.file.service.ISysFileService;
import com.ruoyi.system.api.domain.SysFile;

/**
 * 文件请求处理
 *
 * @author ruoyi
 */
@Slf4j
@RestController
public class SysFileController {

    @Autowired
    private ISysFileService sysFileService;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public R<SysFile> upload(MultipartFile file) {
        try {
            //上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            return R.ok(SysFile.builder()
                               .name(FileUtils.getName(url))
                               .url(url).build());
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据文件名字与地址
     */
    @DeleteMapping("/deleteFile")
    public void deleteFile() {

    }

}