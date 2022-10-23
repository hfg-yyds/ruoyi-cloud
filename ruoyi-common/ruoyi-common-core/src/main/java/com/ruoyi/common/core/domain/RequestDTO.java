package com.ruoyi.common.core.domain;

import lombok.Getter;

/**
 * <p>
 *      请求类型
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Getter
public class RequestDTO<T> {

    /**
     * 请求
     */
    private T body;

    /**
     * 请求头
     */
    private Header header;

}
