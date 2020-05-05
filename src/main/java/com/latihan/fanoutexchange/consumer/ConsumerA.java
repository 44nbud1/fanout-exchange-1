package com.latihan.fanoutexchange.consumer;

import com.latihan.fanoutexchange.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsumerA
{
    @RabbitListener(queues = "admin")
    public void consumeFileA(Student student)
    {
        System.out.println("-------------A------------");
        System.out.println((student.getName()));
        System.out.println("-------------A------------");
    }
}
