package com.ruoyi.system.api.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteLogService;
import com.ruoyi.system.api.domain.SysLogininfor;
import com.ruoyi.system.api.domain.SysOperLog;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
@Slf4j
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public R<Boolean> saveLog(SysOperLog sysOperLog, String source) {
                return R.fail("保存日志失败");
            }
            @Override
            public R<Boolean> saveLogininfor(SysLogininfor sysLogininfor, String source) {
                return R.fail("保存访问记录s失败");
            }
        };
    }

}
