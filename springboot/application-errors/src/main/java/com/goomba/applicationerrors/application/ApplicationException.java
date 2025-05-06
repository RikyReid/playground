package com.goomba.applicationerrors.application;

import org.springframework.http.HttpStatus;

public abstract class ApplicationException extends RuntimeException {
    public abstract String getErrorCode();
    public abstract HttpStatus getHttpStatus();

    ApplicationException(String message) {
        super(message);
    }
}
