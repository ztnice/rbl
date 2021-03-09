package com.cc.site.rbl.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author haozt
 * @since 2021/3/9
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiver2接收到消息:" + message);
    }
}
