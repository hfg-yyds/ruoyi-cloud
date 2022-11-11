package com.ruoyi.common.core.exception.busi.enums;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.core.exception.busi.BusinessException;
import com.ruoyi.common.core.exception.busi.IException;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
public enum FileException implements IException<BusinessException> {
    /**
     * 按行处理文件解析异常
     */
    FILE_PARSE_EXCEPTION("300001","按行处理文件解析异常");

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
    FileException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回异常类型
     *
     * @param message 异常描述
     * @return BusinessException
     */
    @Override
    public BusinessException exception(Object... message) {
        return BusinessException.exception(code, StrUtil.format(this.msg, message));
    }

}
