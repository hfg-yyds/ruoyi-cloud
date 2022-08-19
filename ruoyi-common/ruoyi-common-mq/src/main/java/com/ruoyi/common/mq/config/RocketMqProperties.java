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

    /**
     * nameSrv
     */
    private String nameSrvAddress;

    /**
     * 超时
     */
    private int timeOut = 3000;

    /**
     * 生产者配置集合
     */
    private static final Map<String,Producer> producer = Maps.newConcurrentMap();

    /**
     * 消费者配置集合
     */
    private static final Map<String,Consumer> consumer = Maps.newConcurrentMap();

    public Map<String,Producer> getProducer() {
        return producer;
    }

    public Map<String,Consumer> getConsumer() {
        return consumer;
    }

    @Data
    public static class Producer {
        /**
         * 生产者组
         */
        private String producerGroup;

        /**
         * 默认主题要创建的队列数
         */
        private Integer defaultTopicQueueNums = 4;

        /**
         * 发送消息超时
         */
        private Integer sendMsgTimeout = 3000;

        /**
         * 压缩消息体阈值
         */
        private Integer compressMsgBodyOverHowmuch = 1024 * 4;

        /**
         * 在同步模式中声明发送失败之前在内部执行的最大重试次数。
         * 可能会导致消息重复
         */
        private int retryTimesWhenSendFailed = 2;

        /**
         * 异步模式中声明发送失败之前在内部执行的最大重试次数
         * 可能会导致消息重复
         */
        private int retryTimesWhenSendAsyncFailed = 2;

        /**
         * 最大允许消息大小
         */
        private int maxMessageSize = 1024 * 1024 * 4;
    }

    @Data
    public static class Consumer {

    }

}
