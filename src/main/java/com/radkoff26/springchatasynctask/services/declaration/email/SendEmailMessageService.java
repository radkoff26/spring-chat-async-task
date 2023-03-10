package com.radkoff26.springchatasynctask.services.declaration.email;

public interface SendEmailMessageService {
    void sendEmailMessage(String emailTo, String subject, String body);
}
