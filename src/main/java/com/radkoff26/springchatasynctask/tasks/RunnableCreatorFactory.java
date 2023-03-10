package com.radkoff26.springchatasynctask.tasks;

import com.radkoff26.springchatasynctask.domain.dto.QueueMessage;
import com.radkoff26.springchatasynctask.domain.dto.QueueMessageType;
import com.radkoff26.springchatasynctask.tasks.declaration.RunnableCreator;

public interface RunnableCreatorFactory {
    RunnableCreator createRunnableCreator(QueueMessage queueMessage);
}
