package com.ruoyi.common.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *  后台服务之间进行调用建议要传请求头
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Getter
@Setter
public class Header {

    /**
     * 调用方系统名称
     */
    private String system;

    /**
     * 调用方系统代号
     */
    @NotBlank(message = "系统名称不能为空")
    private String systemCode;

    /**
     * 调用方系统
     */
    @NotBlank(message = "调用方系统流水不能为空")
    private String callSystemSerial;

    /**
     * 当前页数
     */
    private String current;

    /**
     * 每页大小
     */
    private String size;

}
