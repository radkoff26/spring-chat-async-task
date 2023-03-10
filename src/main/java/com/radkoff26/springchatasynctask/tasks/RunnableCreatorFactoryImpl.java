package com.radkoff26.springchatasynctask.tasks;

import org.springframework.stereotype.Component;

import com.radkoff26.springchatasynctask.domain.dto.QueueMessage;
import com.radkoff26.springchatasynctask.domain.dto.QueueMessageType;
import com.radkoff26.springchatasynctask.exception.NotImplementedTaskException;
import com.radkoff26.springchatasynctask.services.declaration.email.SendEmailMessageService;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;
import com.radkoff26.springchatasynctask.tasks.implementation.EmailSubmissionLinkRunnableCreator;
import com.radkoff26.springchatasynctask.tasks.implementation.MailCodeRunnableCreator;

@Component
public class RunnableCreatorFactoryImpl implements RunnableCreatorFactory {
    private final SendEmailMessageService sendEmailMessageService;

    public RunnableCreatorFactoryImpl(SendEmailMessageService sendEmailMessageService) {
        this.sendEmailMessageService = sendEmailMessageService;
    }

    @Override
    public RunnableCreator createRunnableCreator(QueueMessage queueMessage) {
        switch (queueMessage.type()) {
            case SEND_EMAIL_CODE -> {
                return new MailCodeRunnableCreator(sendEmailMessageService);
            }
            case SEND_EMAIL_SUBMISSION -> {
                return new EmailSubmissionLinkRunnableCreator(sendEmailMessageService);
            }
            default -> throw new NotImplementedTaskException("Task " + queueMessage.type() + " is not implemented!");
        }
    }
}
