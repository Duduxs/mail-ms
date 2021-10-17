package com.edudev.mailms.application.ports;

import com.edudev.mailms.application.models.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EmailService {

    Email sendEmail(Email email);
    Page<Email> findAll(Pageable pageable);
    Optional<Email> findById(UUID emailId);
}
