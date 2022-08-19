package com.ruoyi.common.mq.config;

import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.common.mq.config.RocketMqProperties
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMqProperties {

    private String nameSrvAddress;

    private int timeOut = 3000;

    private static final Map<String,Producer> producer = Maps.newConcurrentMap();

    private static final Map<String,Consumer> consumer = Maps.newConcurrentMap();

    public Map<String,Producer> getProducer() {
        return producer;
    }

    public Map<String,Consumer> getConsumer() {
        return consumer;
    }

    @Data
    public static class Producer {

    }

    @Data
    public static class Consumer {

    }

}
