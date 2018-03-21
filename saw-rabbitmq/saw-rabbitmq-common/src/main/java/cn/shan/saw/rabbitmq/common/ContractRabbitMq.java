package cn.shan.saw.rabbitmq.common;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 合同消息载体
 * Created by shanlehong on 2018/3/21.
 */
@Data
public class ContractRabbitMq {
    private String id;
    private String name;
    private List<String> testList;
    private Date createDate;
}
