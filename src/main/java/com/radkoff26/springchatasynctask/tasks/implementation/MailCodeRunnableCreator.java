package com.radkoff26.springchatasynctask.tasks.implementation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.radkoff26.springchatasynctask.exception.DataNotGivenException;
import com.radkoff26.springchatasynctask.services.declaration.MailCodeService;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MailCodeRunnableCreator implements RunnableCreator {
    private final MailCodeService mailCodeService;

    public MailCodeRunnableCreator(MailCodeService mailCodeService) {
        this.mailCodeService = mailCodeService;
    }

    @Override
    public Runnable create(Map<String, Object> arguments) {
        return () -> {
            String email = (String) arguments.get("email");
            String code = (String) arguments.get("code");
            if (email == null || code == null) {
                throw new DataNotGivenException("Arguments do not contain email and/or code!");
            }
            log.info(String.format("Sending submission code to %s...", email));
            mailCodeService.sendCode(email, code);
            log.info(String.format("Submission code was sent to %s!", email));
        };
    }
}