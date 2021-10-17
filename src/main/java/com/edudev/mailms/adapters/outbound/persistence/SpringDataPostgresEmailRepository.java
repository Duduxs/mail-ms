package com.edudev.mailms.adapters.outbound.persistence;

import com.edudev.mailms.application.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPostgresEmailRepository extends JpaRepository<Email, UUID> {
}
