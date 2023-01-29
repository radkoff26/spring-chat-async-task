package com.radkoff26.springchatasynctask.exception;

public class NotImplementedTaskException extends RuntimeException {
    public NotImplementedTaskException() {
        super();
    }

    public NotImplementedTaskException(String message) {
        super(message);
    }

    public NotImplementedTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplementedTaskException(Throwable cause) {
        super(cause);
    }

    protected NotImplementedTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
