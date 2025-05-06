package com.goomba.playground.tasks.application;

import com.goomba.playground.tasks.domain.model.TaskUser;

public record TaskUserDO(long id, String name) {
    TaskUserDO(TaskUser user) {
        this(user.id(), user.name());
    }
}
