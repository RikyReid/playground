package com.goomba.playground.tasks;

public record UserDO(long id, String name) {
    UserDO(User user) {
        this(user.id(), user.name());
    }
}
