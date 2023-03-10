package com.radkoff26.springchatasynctask.tasks.implementation;

import java.util.Map;

import com.radkoff26.springchatasynctask.exception.DataNotGivenException;
import com.radkoff26.springchatasynctask.services.declaration.email.SendEmailMessageService;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSubmissionLinkRunnableCreator implements RunnableCreator {
    private final SendEmailMessageService sendEmailMessageService;

    public EmailSubmissionLinkRunnableCreator(SendEmailMessageService sendEmailMessageService) {
        this.sendEmailMessageService = sendEmailMessageService;
    }

    @Override
    public Runnable create(Map<String, Object> arguments) {
        return () -> {
            String userId = (String) arguments.get("userId");
            String email = (String) arguments.get("email");
            String code = (String) arguments.get("code");
            if (userId == null || email == null || code == null) {
                throw new DataNotGivenException("Arguments do not contain email and/or code!");
            }
            log.info("Sending email submission code to {}...", email);
            String body = String.format("To submit email code go to this link %s %s", code, userId); // Stub TODO
            sendEmailMessageService.sendEmailMessage(email, "Email submission", body);
            log.info("Email submission code was sent to {}!", email);
        };
    }
}
