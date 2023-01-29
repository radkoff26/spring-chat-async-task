package com.radkoff26.springchatasynctask.tasks.declaration;

import java.util.Map;

public interface RunnableCreator {
    Runnable create(Map<String, Object> arguments);
}
