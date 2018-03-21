package cn.shan.saw.rabbitmq.receive.service;

import cn.shan.saw.rabbitmq.common.ContractRabbitMq;
import cn.shan.saw.rabbitmq.common.RabbitMqQueue;
import cn.shan.saw.rabbitmq.common.TenantRabbitMq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by shanlehong on 2018/3/21.
 */
@Component
public class ReceiverService {
    @RabbitListener(queues = RabbitMqQueue.CONTRACE_SELF)
    @RabbitHandler
    public void receiveContractQueue(ContractRabbitMq contract) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            System.out.println("Received contract<" + objectMapper.writeValueAsString(contract) + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqQueue.CONTRACE_TENANT)
    public void receiveTenantQueue(TenantRabbitMq tenant) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            System.out.println("Received contract<" + objectMapper.writeValueAsString(tenant) + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
