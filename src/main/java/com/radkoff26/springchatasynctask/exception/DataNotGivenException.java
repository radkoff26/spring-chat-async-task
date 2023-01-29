package com.radkoff26.springchatasynctask.exception;

public class DataNotGivenException extends RuntimeException {
    public DataNotGivenException() {
        super();
    }

    public DataNotGivenException(String message) {
        super(message);
    }

    public DataNotGivenException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotGivenException(Throwable cause) {
        super(cause);
    }

    protected DataNotGivenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
