package com.radkoff26.springchatasynctask.domain.dto;

import java.io.Serializable;
import java.util.Map;

public record QueueMessage(QueueMessageType type, Map<String, Object> arguments) implements Serializable {
}
