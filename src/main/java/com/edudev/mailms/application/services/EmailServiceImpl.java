package com.edudev.mailms.application.services;

import com.edudev.mailms.application.models.Email;
import com.edudev.mailms.application.ports.EmailRepository;
import com.edudev.mailms.application.ports.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.edudev.mailms.application.models.enums.StatusEmail.ERROR;
import static com.edudev.mailms.application.models.enums.StatusEmail.SENT;

public class EmailServiceImpl implements EmailService {


    private final EmailRepository repository;

    private final JavaMailSender sender;

    public EmailServiceImpl(final EmailRepository repository, final JavaMailSender sender){
        this.repository = repository;
        this.sender = sender;
    }

    @Override
    public Email sendEmail(Email email) {
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
        return email;
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return repository.findById(emailId);
    }
}
