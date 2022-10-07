package com.ruoyi.test;

import com.ruoyi.common.core.exception.busi.BusinessException;
import com.ruoyi.common.core.exception.busi.enums.SystemBusiness;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-10-07
 */
@Slf4j
public class TestException {

    @Test
    public void test1() {
        try {
            System.out.println("测试异常能否抛出");
            int i = 10/0;
        }catch (Exception e) {
            log.error(e.getMessage());
            throw SystemBusiness.OUT_CALL_EXCEPTION.exception(2014);
        }

    }

}
