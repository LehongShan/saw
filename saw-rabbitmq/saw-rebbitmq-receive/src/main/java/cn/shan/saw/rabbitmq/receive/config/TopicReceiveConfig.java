package cn.shan.saw.rabbitmq.receive.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by shanlehong on 2018/3/21.
 */
@Configuration
public class TopicReceiveConfig {

    @Bean(name = "message")
    public Queue queueMessage(){
        return new Queue("topic.message");
    }
    @Bean(name = "messages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }
    @Bean(name = "sawExchange")
    public TopicExchange exchange(){
        return new TopicExchange("sawExchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
