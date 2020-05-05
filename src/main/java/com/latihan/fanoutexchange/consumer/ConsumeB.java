package com.latihan.fanoutexchange.consumer;

import com.latihan.fanoutexchange.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumeB
{

    @RabbitListener(queues = "admin")
    public void consumeFileB(Student student)
    {
        System.out.println("------------B-------------");
        System.out.println(student.getName());
        System.out.println("------------B-------------");
    }
}
