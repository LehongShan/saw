package cn.shan.saw.rabbitmq.common;

/**
 * exchange交换机配置
 * Created by shanlehong on 2018/3/21.
 */
public interface RabbitMqExchange {
     String CONTRACT_FANOUT = "CONTRACT_FANOUT";
     String CONTRACT_TOPIC = "CONTRACT_TOPIC";
     String CONTRACT_DIRECT = "CONTRACT_DIRECT";
}
