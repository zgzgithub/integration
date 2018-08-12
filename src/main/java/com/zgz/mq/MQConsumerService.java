package com.zgz.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MQConsumerService {
    //修改工厂配置containerFactory = "jmsListenerContainerQueue"
    @JmsListener(destination = "sample.queue") // 监听指定消息队列
    public void receiveQueue(String message) {
        System.out.println(message);

    }
}

