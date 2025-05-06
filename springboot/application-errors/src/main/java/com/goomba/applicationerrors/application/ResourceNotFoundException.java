package com.goomba.applicationerrors.application;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {
    ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "ERR_RESOURCE_NOT_FOUND";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
