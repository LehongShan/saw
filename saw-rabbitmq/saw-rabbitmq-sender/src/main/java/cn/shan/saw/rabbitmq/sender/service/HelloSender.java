package cn.shan.saw.rabbitmq.sender.service;

import cn.shan.saw.rabbitmq.common.ContractRabbitMq;
import cn.shan.saw.rabbitmq.common.RabbitMqExchange;
import cn.shan.saw.rabbitmq.common.RabbitMqQueue;
import cn.shan.saw.rabbitmq.common.RabbitMqRouterKey;
import org.assertj.core.util.Lists;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shanlehong on 2018/3/21.
 */
@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDirect(){

        ContractRabbitMq mq=new ContractRabbitMq();
        mq.setId("15");
        mq.setName("测试");
        mq.setTestList(Lists.newArrayList("111","222"));
        mq.setCreateDate(new Date());
        rabbitTemplate.convertAndSend(RabbitMqQueue.CONTRACE_SELF,mq);
    }

    public void sendByTopic(){
        ContractRabbitMq mq=new ContractRabbitMq();
        mq.setId("15");
        mq.setName("测试");
        mq.setTestList(Lists.newArrayList("111","222"));
        mq.setCreateDate(new Date());
        rabbitTemplate.convertAndSend(RabbitMqExchange.CONTRACT_TOPIC, RabbitMqQueue.CONTRACE_SELF,mq);
    }
}
