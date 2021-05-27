package com.cc.site.rbl.rabbit;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author haozt
 * @since 2021/3/9
 */
//@Component
//@RabbitListener(queues = "hello")
public class HelloReceiver {

//    @RabbitHandler
    public void process(String message){
        System.out.println("receiver1接收到消息:" + message);
    }

//    @RabbitHandler
    public void processObject(Object o){
        System.out.println("receiver1接收到消息:" + JSON.toJSONString(o));
    }

}
