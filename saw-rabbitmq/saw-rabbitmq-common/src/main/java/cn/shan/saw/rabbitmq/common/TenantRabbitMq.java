package cn.shan.saw.rabbitmq.common;

import lombok.Builder;
import lombok.Getter;

/**
 * tenant消息载体
 * Created by shanlehong on 2018/3/21.
 */
@Builder
@Getter
public class TenantRabbitMq {
    private String id;
    private String name;
}
