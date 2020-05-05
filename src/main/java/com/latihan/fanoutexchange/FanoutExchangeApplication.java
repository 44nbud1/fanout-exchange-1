package com.latihan.fanoutexchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FanoutExchangeApplication {

    /*
    spring.rabbitmq.host=localhost
    spring.rabbitmq.virtual-host=/
    spring.rabbitmq.port=5672
    spring.rabbitmq.password=guest
    spring.rabbitmq.username=guest
     */

    // configuration rabbitmq
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.username}")
    private String username;

    // connection
    @Bean
    ConnectionFactory connectionFactory()
    {
        AbstractConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPort(port);
        connectionFactory.setPassword(password);
        connectionFactory.setUsername(username);
        return connectionFactory;
    }

    @Bean
    MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(FanoutExchangeApplication.class, args);
    }

}
