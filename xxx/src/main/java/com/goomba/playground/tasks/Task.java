package com.goomba.playground.tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long createdById;
    private long assigneeId;
    private String name;

    public long id() {
        return id;
    }

    public long createdById() {
        return this.createdById;
    }

    public long assigneeId() {
        return this.assigneeId;
    }

    public String name() {
        return name;
    }

    static Task from(CreateTaskCommand createTaskCommand) {
        var task = new Task();
        task.assigneeId = createTaskCommand.assigneeId();
        task.createdById = createTaskCommand.createdById();
        task.name = createTaskCommand.name();
        return task;
    }
}
