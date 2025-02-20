package com.goomba.playground.tasks;

public record TaskUserDO(long id, String name) {
    TaskUserDO(TaskUser user) {
        this(user.id(), user.name());
    }
}
