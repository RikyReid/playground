package com.goomba.applicationerrors.application;

import java.time.Instant;

public record ApplicationErrorResponse(String message, int httpStatus, String errorCode, Instant timestamp) {
    ApplicationErrorResponse(String message, int httpStatus, String errorCode) {
        this(message, httpStatus, errorCode, Instant.now());
    }
}
