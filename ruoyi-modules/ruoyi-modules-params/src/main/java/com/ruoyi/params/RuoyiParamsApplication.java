package com.ruoyi.params;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *  参数中心模块
 * </p>
 *
 * @author: 韩福贵
 * @date: 2022-12-03
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class RuoyiParamsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoyiParamsApplication.class,args);
    }
}
