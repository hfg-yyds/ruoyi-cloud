package com.ruoyi.common.core.exception.busi;

/**
 * <p>
 *  业务异常模块的顶级接口
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
public interface IException {

    /**
     * 返回业务异常
     * @param message 异常描述
     * @return BusinessException
     */
    BusinessException exception(Object ...message);

}
