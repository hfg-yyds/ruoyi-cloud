package com.ruoyi.common.core.exception.busi.enums;

import com.ruoyi.common.core.exception.busi.IException;
import lombok.Getter;

/**
 * <p>
 *  任务模块业务异常枚举
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Getter
public enum JobBusiness {
    /**
     * 外调异常
     */
    OUT_CALL_EXCEPTION("320110","外调异常")

    ;

    /**
     * 错误码
     */
    private final String code;
    /**
     * 错误信息
     */
    private final String msg;

    /**
     * 构造器
     * @param code 错误码
     * @param msg 错误信息
     */
    JobBusiness(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
