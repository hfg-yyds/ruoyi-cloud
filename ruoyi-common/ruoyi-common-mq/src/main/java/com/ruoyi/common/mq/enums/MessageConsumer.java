package com.ruoyi.common.mq.enums;

import lombok.Getter;

/**
 * <p>
 *
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.common.mq.enums.MessageConsumer
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
@Getter
public enum MessageConsumer {

    TEST("1","2");

    ;
    private final String code;

    private final String desc;

    MessageConsumer(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
