package com.goomba.playground.tasks;

public record CreateTaskEvent(long id, long createdById, long assigneeId, String name) {
    CreateTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.createdById(), taskDO.assigneeId(), taskDO.name());
    }
}
