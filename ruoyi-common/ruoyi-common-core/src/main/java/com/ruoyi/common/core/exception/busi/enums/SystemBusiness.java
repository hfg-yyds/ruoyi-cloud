package com.ruoyi.common.core.exception.busi.enums;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.core.exception.busi.BusinessException;
import com.ruoyi.common.core.exception.busi.IException;
import lombok.Getter;

/**
 * <p>
 *  系统模块业务异常枚举,这个建议放在系统模块内
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Getter
public enum SystemBusiness implements IException<BusinessException> {

    /**
     * 外调接口异常
     */
    OUT_CALL_EXCEPTION("320110","{}接口外调异常"),

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
    SystemBusiness(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回业务异常
     *
     * @param message 异常描述
     * @return BusinessException
     */
    @Override
    public BusinessException exception(Object... message) {
        return BusinessException.exception(code, StrUtil.format(this.msg, message));
    }

}
