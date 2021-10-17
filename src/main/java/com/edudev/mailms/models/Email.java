package com.edudev.mailms.models;

import com.edudev.mailms.enums.StatusEmail;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    private String ownerRef;

    private String emailFrom;

    private String emailTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateEmail;

    private StatusEmail status;
}
