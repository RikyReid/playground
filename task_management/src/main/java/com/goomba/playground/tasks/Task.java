package com.goomba.playground.tasks;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private TaskUser createdBy;

    @ManyToOne
    private TaskUser assignee;

    private String name;

    long id() {
        return id;
    }

    TaskUser createdBy() {
        return this.createdBy;
    }

    TaskUser assignee() {
        return this.assignee;
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
