package com.latihan.fanoutexchange.config;

import com.rabbitmq.client.impl.AMQBasicProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class fanoutProducerConfig
{

    @Value("${spring.rabbitmq.fanout-exchange}")
     private String exchange ;

    @Value("${spring.rabbitmq.queue-fanout}")
    private String queue;

    @Bean
    Queue fanoutQueue()
    {
        return new Queue(queue,true,false,false);
    }

    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(exchange);
    }

    @Bean
    Binding fanoutBinding(Queue fanoutQueue,FanoutExchange fanoutExchange)
    {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    MessageConverter jsonConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonConverter());
        return rabbitTemplate;
    }
}
