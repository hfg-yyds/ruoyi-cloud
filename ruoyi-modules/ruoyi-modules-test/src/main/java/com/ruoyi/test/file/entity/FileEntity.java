package com.ruoyi.test.file.entity;

import com.ruoyi.common.core.annotation.FieldOrder;
import com.ruoyi.common.file.interfaces.OrderEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-11-11
 */
@Data
public class FileEntity implements OrderEntity {

    @FieldOrder(order = 0)
    private String name;

    @FieldOrder(order = 1)
    private String address;

    public static FileEntity getInstance() {
        return new FileEntity();
    }
}
