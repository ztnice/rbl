package com.cc.site.rbl.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author haozt
 * @since 2021/3/9
 */
//@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }
}
