package com.edudev.mailms.adapters.configs;

import com.edudev.mailms.MailMsApplication;
import com.edudev.mailms.application.ports.EmailRepository;
import com.edudev.mailms.application.services.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@ComponentScan(basePackageClasses = MailMsApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepository repository, JavaMailSender sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

}