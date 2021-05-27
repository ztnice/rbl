package com.cc.site.rbl.rabbit;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author haozt
 * @since 2021/3/9
 */
//@Component
//@RabbitListener(queues = "topic.message")
public class TopicReceiver {

//    @RabbitHandler
    public void receiver(Map<String,Object> map){
        System.err.println("TopicReceiver接收到了："+map);
    }

}
