package com.radkoff26.springchatasynctask.tasks;

import org.springframework.stereotype.Component;

import com.radkoff26.springchatasynctask.domain.dto.QueueMessageType;
import com.radkoff26.springchatasynctask.exception.NotImplementedTaskException;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

@Component
public class RunnableCreatorFactoryImpl implements RunnableCreatorFactory {
    private final RunnableCreator mailCodeRunnable;
    public RunnableCreatorFactoryImpl(RunnableCreator mailCodeRunnable) {
        this.mailCodeRunnable = mailCodeRunnable;
    }

    @Override
    public RunnableCreator createRunnableCreator(QueueMessageType queueMessageType) {
        switch (queueMessageType) {
            case SEND_EMAIL_CODE -> {
                return mailCodeRunnable;
            }
            default -> throw new NotImplementedTaskException("Task " + queueMessageType + " is not implemented!");
        }
    }
}
