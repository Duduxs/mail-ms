package com.edudev.mailms.adapters.inbound.resources;

import com.edudev.mailms.adapters.inbound.dtos.EmailDTO;
import com.edudev.mailms.application.models.Email;
import com.edudev.mailms.application.services.EmailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class EmailResource {

    @Autowired
    EmailServiceImpl service;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> insert(@RequestBody @Valid EmailDTO emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        service.sendEmail(email);

        return new ResponseEntity<>(email, CREATED);
    }
}
