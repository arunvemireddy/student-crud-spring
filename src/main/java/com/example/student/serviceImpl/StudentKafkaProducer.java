package com.example.student.serviceImpl;

import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentKafkaProducer {
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public StudentKafkaProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStudent(Student event) {

        kafkaTemplate.send("student", String.valueOf(event.getStudent_id()), event)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Message sent to partition: "
                                + result.getRecordMetadata().partition());
                    } else {
                        System.err.println("Error sending message: " + ex.getMessage());
                    }
                });
    }
}
