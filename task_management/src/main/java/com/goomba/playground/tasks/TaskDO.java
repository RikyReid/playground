package com.goomba.playground.tasks;

public record TaskDO(long id, long createdById, UserDO assignee, String name) {
    TaskDO(Task task) {
        this(task.id(), task.createdById(), new UserDO(task.assignee()), task.name());
    }
}
