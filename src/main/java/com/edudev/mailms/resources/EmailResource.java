package com.edudev.mailms.resources;

import com.edudev.mailms.dtos.EmailDTO;
import com.edudev.mailms.models.Email;
import com.edudev.mailms.services.EmailService;
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
    EmailService service;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailDTO> insert(@RequestBody @Valid EmailDTO emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        service.sendEmail(email);
        return new ResponseEntity(email, CREATED);

    }
}
