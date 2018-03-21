package cn.shan.saw.rabbitmq.sender.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by shanlehong on 2018/3/21.
 */
@Configuration
public class DirectSenderConfig {

    @Bean
    public Queue queue(){
        return new Queue("queue");
    }
}
