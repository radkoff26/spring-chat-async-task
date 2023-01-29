package com.radkoff26.springchatasynctask.services.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.radkoff26.springchatasynctask.services.declaration.MailCodeService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:application.yml")
public class MailCodeServiceImpl implements MailCodeService {
    @Value("${email}")
    private String emailFrom;
    private final JavaMailSender javaMailSender;

    public MailCodeServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendCode(String email, String code) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false);
            helper.setFrom(emailFrom);
            helper.setTo(email);
            helper.setSubject("Authorization Code");
            helper.setText(String.format("Your confirmation code is %s", code));
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
