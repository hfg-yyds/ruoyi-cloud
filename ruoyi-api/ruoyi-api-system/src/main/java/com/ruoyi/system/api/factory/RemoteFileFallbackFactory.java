package com.ruoyi.system.api.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteFileService;

/**
 * 文件服务降级处理
 *
 * @author ruoyi
 */
@Slf4j
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService> {
    /**
     * Returns an instance of the fallback appropriate for the given cause.
     *
     * @param cause cause of an exception.
     * @return fallback
     */
    @Override
    public RemoteFileService create(Throwable cause) {
        return file -> R.fail(String.format("上传文件失败：{%s}",cause.getMessage()));
    }

}
