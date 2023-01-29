package com.radkoff26.springchatasynctask.services.declaration;

public interface MailCodeService {
    void sendCode(String email, String code);
}
