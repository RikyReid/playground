package com.goomba.playground.tasks.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Task name already exists")
class ExistingNameException extends RuntimeException {
    ExistingNameException() {
        super();
    }
}
