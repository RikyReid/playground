package com.goomba.playground.tasks;

public record TaskDO(long id, TaskUserDO createdBy, TaskUserDO assignee, String name) {
    TaskDO(Task task) {
        this(task.id(), new TaskUserDO(task.createdBy()),
                new TaskUserDO(task.assignee()), task.name());
    }
}
