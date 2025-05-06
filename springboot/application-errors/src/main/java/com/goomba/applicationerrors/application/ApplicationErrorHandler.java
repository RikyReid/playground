package com.goomba.applicationerrors.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationErrorHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationErrorResponse> handleApplicationException(ApplicationException applicationException) {
        var errorResponse = new ApplicationErrorResponse(applicationException.getMessage(),
                applicationException.getHttpStatus().value(),
                applicationException.getErrorCode());
        return new ResponseEntity<>(errorResponse, applicationException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationErrorResponse> handleException(Exception exception) {
        var errorResponse = new ApplicationErrorResponse("An unexpected error occurred.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "ERR_INTERNAL_SERVER");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
