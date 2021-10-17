package com.edudev.mailms.adapters.inbound.consumers;


import com.edudev.mailms.adapters.inbound.dtos.EmailDTO;
import com.edudev.mailms.application.models.Email;
import com.edudev.mailms.application.services.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl service;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO dto) {
        Email email = new Email();
        BeanUtils.copyProperties(dto, email);
        service.sendEmail(email);
        System.out.println("Email Status: " + email.getStatus());
    }
}
