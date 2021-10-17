package com.edudev.mailms.adapters.outbound.persistence;

import com.edudev.mailms.application.models.Email;
import com.edudev.mailms.application.ports.EmailRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepository {

    private final SpringDataPostgresEmailRepository emailRepository;

    public PostgresEmailRepository(final SpringDataPostgresEmailRepository orderRepository) {
        emailRepository = orderRepository;
    }

    @Override
    public Email save(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return emailRepository.findAll(pageable);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
