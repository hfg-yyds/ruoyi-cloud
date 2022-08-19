package com.ruoyi.common.mq.core;

import com.ruoyi.common.mq.config.RocketMqProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * <p>
 *  抽象默认消息生产者
 * </p>
 * Copyright @2017-2022
 *
 * @moduleName: ruoyi
 * @className: com.ruoyi.common.mq.SynProducer
 * @author: 韩福贵
 * @date: 2022-08-19
 * @version: 1.0
 */
@Slf4j
public abstract class AbstractDefaultProducer implements IProducer {

    /**
     * RocketMq配置
     */
    @Autowired
    private RocketMqProperties rocketMqProperties;

    /**
     * 默认RocketMQ生成者
     */
    protected DefaultMQProducer defaultMQProducer;

    /**
     * @return 返回生产者标识
     */
    protected abstract String getServiceId();

    /**
     * 构建生产者
     */
    protected void producerBuilder() {
        RocketMqProperties.Producer producer = rocketMqProperties.getProducer().get(getServiceId());
        defaultMQProducer= new DefaultMQProducer();
        defaultMQProducer.setNamesrvAddr(rocketMqProperties.getNameSrvAddress());
        defaultMQProducer.setProducerGroup(producer.getProducerGroup());
        //TODO
    }

    @PostConstruct
    public void registerProducer() {
        producerBuilder();
    }

}
