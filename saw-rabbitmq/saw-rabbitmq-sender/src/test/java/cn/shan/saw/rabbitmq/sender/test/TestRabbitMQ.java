package cn.shan.saw.rabbitmq.sender.test;

import cn.shan.saw.rabbitmq.sender.service.HelloSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shanlehong on 2018/3/21.
 */
public class TestRabbitMQ  extends BaseTest{
    @Autowired
    private HelloSender helloSender;

    @Test
    public void testDirectSender(){
        helloSender.sendDirect();
    }

    @Test
    public void testTopicSender(){
        helloSender.sendByTopic();
    }
}
