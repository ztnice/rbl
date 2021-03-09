package com.cc.site.rbl.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haozt
 * @since 2021/3/9
 */

@Configuration
public class TopicRabbitConfig {


   private static final String message = "topic.message";
   private static final String messages = "topic.messages";


   @Bean
   public Queue queueMessage(){
       return new Queue(message);
   }


   @Bean
   public Queue queueMessages(){
       return new Queue(messages);
   }



   @Bean
   TopicExchange exchange(){
       return new TopicExchange("exchange");
   }


   @Bean
   Binding bindingExchangeMessage(TopicExchange exchange){

       return BindingBuilder.bind(queueMessage()).to(exchange).with("topic.message");
   }

    @Bean
    Binding bindingExchangeMessages(TopicExchange exchange){

        return BindingBuilder.bind(queueMessages()).to(exchange).with("topic.#");
    }

}
