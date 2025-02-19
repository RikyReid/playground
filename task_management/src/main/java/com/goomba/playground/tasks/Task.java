package com.goomba.playground.tasks;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long createdById;

    @ManyToOne
    private User assignee;

    private String name;

    long id() {
        return id;
    }

    long createdById() {
        return this.createdById;
    }

    User assignee() {
        return this.assignee;
    }

    String name() {
        return name;
    }

    Task reassignTask(User assignee) {
        this.assignee = assignee;
        return this;
    }

    static Task from(CreateTaskValues createTaskValues) {
        var task = new Task();
        task.assignee = createTaskValues.assignee();
        task.createdById = createTaskValues.createdById();
        task.name = createTaskValues.name();
        return task;
    }
}
