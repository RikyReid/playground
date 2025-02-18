package com.goomba.playground.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task not found")
class ResourceNotFoundException extends RuntimeException {
    ResourceNotFoundException() {
        super();
    }
}
