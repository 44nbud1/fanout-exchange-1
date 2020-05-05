package com.latihan.fanoutexchange.controller;

import com.latihan.fanoutexchange.consumer.ConsumeB;
import com.latihan.fanoutexchange.consumer.ConsumerA;
import com.latihan.fanoutexchange.model.Student;
import com.latihan.fanoutexchange.producer.AdminProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @Autowired
    AdminProducer adminProducer;

    @Autowired
    ConsumeB consumeB;

    @Autowired
    ConsumerA consumerA;

    @PostMapping("/fanout")
    public ResponseEntity<?> test(@RequestBody Student student)
    {
        adminProducer.sendToRabbit(student);

        consumerA.consumeFileA(student);
        consumeB.consumeFileB(student);
        return ResponseEntity.ok("ok");
    }
}
