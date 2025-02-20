package com.goomba.playground.tasks;

public record TaskDO(long id, long createdById, TaskUserDO assignee, String name) {
    TaskDO(Task task) {
        this(task.id(), task.createdById(), new TaskUserDO(task.assignee()), task.name());
    }
}
