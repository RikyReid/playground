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

    long id() {
        return id;
    }

    long createdById() {
        return this.createdById;
    }

    long assigneeId() {
        return this.assigneeId;
    }

    String name() {
        return name;
    }

    Task reassignTask(long assigneeId) {
        this.assigneeId = assigneeId;
        return this;
    }

    static Task from(CreateTaskCommand createTaskCommand) {
        var task = new Task();
        task.assigneeId = createTaskCommand.assigneeId();
        task.createdById = createTaskCommand.createdById();
        task.name = createTaskCommand.name();
        return task;
    }
}
