package com.goomba.playground.tasks.domain.model;

import com.goomba.playground.tasks.application.CreateTaskValues;
import jakarta.persistence.*;

public class Task {
    private long id;

    private long userId;

    private long assigneeId;

    private String name;

    long id() {
        return id;
    }

    long assignee() {
        return this.assigneeId;
    }

    String name() {
        return name;
    }

    Task reassignTask(TaskUser assignee) {
        this.assignee = assignee;
        return this;
    }

    static Task from(CreateTaskValues createTaskValues) {
        var task = new Task();
        task.assignee = createTaskValues.assignee();
        task.createdBy = createTaskValues.createdBy();
        task.name = createTaskValues.name();
        return task;
    }
}
