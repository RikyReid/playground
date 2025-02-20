package com.goomba.playground.usermanagement;

public record UserCreatedEvent(long id, String name) {
    UserCreatedEvent(User user) {
        this(user.id(), user.name());
    }
}
