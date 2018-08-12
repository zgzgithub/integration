//package com.zgz.mq;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//import org.springframework.jms.core.JmsMessagingTemplate;
//
//import javax.jms.Queue;
//
//@Configuration
//public class ActivemqClusterConfiguration {
//    @Value("${spring.activemq.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public Queue productActiveMQQueue(){
//        return new ActiveMQQueue("sample.queue");
//    }
//
//
//    @Bean(name = "jmsListenerContainerQueue")
//    public JmsListenerContainerFactory<?> jmsListenerContainerQueue() {
//        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
//        bean.setConnectionFactory(new ActiveMQConnectionFactory(brokerUrl));
//        return bean;
//    }
//
//    @Bean
//    public JmsMessagingTemplate jmsMessagingTemplate(){
//        return new JmsMessagingTemplate(new ActiveMQConnectionFactory(brokerUrl));
//    }
//}
