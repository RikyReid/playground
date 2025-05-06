package com.goomba.playground.usermanagement;

public record UserDO(long id, String name) {
    UserDO(User user) {
        this(user.id(), user.name());
    }
}
