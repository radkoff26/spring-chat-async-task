package com.radkoff26.springchatasynctask.listeners;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.radkoff26.springchatasynctask.async.AsyncTaskExecutor;
import com.radkoff26.springchatasynctask.domain.dto.QueueMessage;
import com.radkoff26.springchatasynctask.tasks.RunnableCreatorFactory;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

import lombok.extern.log4j.Log4j2;

@EnableRabbit
@Component
@Log4j2
public class RabbitMQListener {
    private final AsyncTaskExecutor executor;
    private final RunnableCreatorFactory runnableCreatorFactory;

    public RabbitMQListener(AsyncTaskExecutor executor, RunnableCreatorFactory runnableCreatorFactory) {
        this.executor = executor;
        this.runnableCreatorFactory = runnableCreatorFactory;
    }

    @RabbitListener(queues = "tasks")
    public void processTasks(QueueMessage queueMessage) {
        log.info("Message was received: " + queueMessage);
        RunnableCreator runnableCreator = runnableCreatorFactory.createRunnableCreator(queueMessage);
        Runnable runnable = runnableCreator.create(queueMessage.arguments());
        executor.executeTask(runnable);
    }
}
