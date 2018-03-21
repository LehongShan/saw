package cn.shan.saw.rabbitmq.sender.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shanlehong on 2018/3/21.
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirect(){
        amqpTemplate.convertAndSend("queue","hello,rabbitmq");
    }

    public void sendByTopic(){
        amqpTemplate.convertAndSend("sawExchange","topic.message","hello,rabbitmq");
    }
}
