package com.dexterv.financetracker.exceptions;

public class SigninUserNotFoundException extends UserNotFoundException {
    public SigninUserNotFoundException() {
    }

    public SigninUserNotFoundException(String message) {
        super(message);
    }

    public SigninUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SigninUserNotFoundException(Throwable cause) {
        super(cause);
    }

    public SigninUserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
