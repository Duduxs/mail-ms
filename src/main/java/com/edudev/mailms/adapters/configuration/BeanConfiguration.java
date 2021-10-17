package com.edudev.mailms.adapters.configuration;

import com.edudev.mailms.MailMsApplication;
import com.ms.email.application.ports.EmailRepositoryPort;
import com.ms.email.application.ports.SendEmailServicePort;
import com.ms.email.application.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MailMsApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
