package com.ruoyi.common.core.exception.busi;

/**
 * <p>
 *  异常模块的顶级接口
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
public interface IException<T> {

    /**
     * 返回异常类型
     * @param message 异常描述
     * @return BusinessException
     */
    T exception(Object ...message);

}
