package com.ruoyi.test.enums;

import lombok.Getter;

/**
 * <p>
 *
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.test.enums.MessageConsumer
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
@Getter
public enum ConsumerEnums {

    TEST("1","2"),

    ;

    private final String code;

    private final String desc;

    ConsumerEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
