package com.latihan.fanoutexchange.producer;

import com.latihan.fanoutexchange.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminProducer
{
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.fanout-exchange}")
    private String exchange ;

    public void sendToRabbit(Student student)
    {
        amqpTemplate.convertAndSend(exchange,"",student);
    }
}
