package cn.shan.saw.rabbitmq.receive.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shanlehong on 2018/3/21.
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMq {

    private String addresses;
    private String username;
    private String password;


}
