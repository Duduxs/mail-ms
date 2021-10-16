package com.edudev.mailms.services;

import com.edudev.mailms.models.Email;
import com.edudev.mailms.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.edudev.mailms.enums.StatusEmail.ERROR;
import static com.edudev.mailms.enums.StatusEmail.SENT;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());

        try {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            sender.send(message);

            email.setStatus(SENT);
        } catch (MailException e) {
            email.setStatus(ERROR);
            throw e;
        } finally {
            repository.save(email);
        }
    }
}
