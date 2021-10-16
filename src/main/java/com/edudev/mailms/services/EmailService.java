package com.edudev.mailms.services;

import com.edudev.mailms.models.Email;
import com.edudev.mailms.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;


    public void sendEmail(Email email) {
        email.
    }
}
