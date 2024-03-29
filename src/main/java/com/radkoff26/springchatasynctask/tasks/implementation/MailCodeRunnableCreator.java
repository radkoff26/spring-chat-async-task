package com.radkoff26.springchatasynctask.tasks.implementation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.radkoff26.springchatasynctask.exception.DataNotGivenException;
import com.radkoff26.springchatasynctask.services.declaration.email.SendEmailMessageService;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MailCodeRunnableCreator implements RunnableCreator {
    private final SendEmailMessageService sendEmailMessageService;

    public MailCodeRunnableCreator(SendEmailMessageService sendEmailMessageService) {
        this.sendEmailMessageService = sendEmailMessageService;
    }

    @Override
    public Runnable create(Map<String, Object> arguments) {
        return () -> {
            String email = (String) arguments.get("email");
            String code = (String) arguments.get("code");
            if (email == null || code == null) {
                throw new DataNotGivenException("Arguments do not contain email and/or code!");
            }
            log.info("Sending authorization code to {}...", email);
            String body = String.format("Your authorization code is %s", code);
            sendEmailMessageService.sendEmailMessage(email, "Authorization email code", body);
            log.info("Authorization code was sent to {}!", email);
        };
    }
}