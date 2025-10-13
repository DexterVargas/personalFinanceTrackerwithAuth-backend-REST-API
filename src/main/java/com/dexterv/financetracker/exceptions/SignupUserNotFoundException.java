package com.dexterv.financetracker.exceptions;

public class SignupUserNotFoundException extends UserNotFoundException {
    public SignupUserNotFoundException() {
    }

    public SignupUserNotFoundException(String message) {
        super(message);
    }

    public SignupUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignupUserNotFoundException(Throwable cause) {
        super(cause);
    }

    public SignupUserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
