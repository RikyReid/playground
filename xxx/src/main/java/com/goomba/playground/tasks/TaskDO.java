package com.goomba.playground.tasks;

public record TaskDO(long id, long createdById, long assigneeId, String name) {
    TaskDO(Task task) {
        this(task.id(), task.createdById(), task.assigneeId(), task.name());
    }
}
