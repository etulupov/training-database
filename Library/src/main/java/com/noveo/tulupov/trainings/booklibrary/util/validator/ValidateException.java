package com.noveo.tulupov.trainings.booklibrary.util.validator;

public class ValidateException extends Exception {
    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
