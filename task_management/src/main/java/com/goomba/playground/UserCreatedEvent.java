package com.goomba.playground;

import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent {
    private String name;

    UserCreatedEvent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
