//package com.ruoyi.test.mq;
//
//import com.ruoyi.common.mq.annotation.MessageBean;
//import com.ruoyi.common.mq.core.AbstractDefaultProducer;
//import com.ruoyi.test.enums.ProducerEnums;
//import org.apache.rocketmq.common.message.Message;
//
///**
// * <p>
// *  测试生产者
// * </p>
// * Copyright @2017-2022
// *
// * @moduleName: ruoyi
// * @className: com.ruoyi.common.mq.TestProducer
// * @author: 韩福贵
// * @date: 2022-08-19
// * @version: 1.0
// */
//@MessageBean
//public class TestDefaultProducer extends AbstractDefaultProducer {
//
//    @Override
//    protected String getServiceId() {
//        return ProducerEnums.PRODUCER_TEST.getCode();
//    }
//
//    /**
//     * 发送同步消息
//     *
//     * @param messageBody message
//     */
//    public void send(String messageBody) {
//        Message message = new Message();
//        try {
//            defaultMQProducer.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void synSend(String messageBody) {
//        Message message = new Message();
//        try {
//            defaultMQProducer.sendOneway(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//}
//
