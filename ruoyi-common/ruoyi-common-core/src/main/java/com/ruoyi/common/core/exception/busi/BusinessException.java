package com.ruoyi.common.core.exception.busi;

import lombok.Getter;

/**
 * <p>
 *  业务异常封装类
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Getter
public class BusinessException extends RuntimeException {

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
    private BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回业务异常信息
     * @param code 返回码
     * @param msg 返回信息
     * @return BusinessException
     */
    public static BusinessException exception(String code, String msg) {
        return new BusinessException(code,msg);
    }

}
