package com.goomba.playground.tasks.domain.model;

import com.goomba.playground.tasks.application.createtask.CreateTaskValues;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

@Entity
public class Task {
    private static final Logger log = LoggerFactory.getLogger(Task.class);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private TaskUser createdBy;

    @ManyToOne
    private TaskUser assignee;

    private String name;

    private Instant createdDate;

    public long id() {
        return id;
    }

    public TaskUser createdBy() {
        return this.createdBy;
    }

    public TaskUser assignee() {
        return this.assignee;
    }

    public String name() {
        return name;
    }

    public Task reassignTask(TaskUser assignee) {
        this.assignee = assignee;
        return this;
    }

    public static Task from(CreateTaskValues createTaskValues) {
        var task = new Task();
        task.assignee = createTaskValues.assignee();
        task.createdBy = createTaskValues.createdBy();
        task.name = createTaskValues.name();
        task.createdDate = Instant.now();
        return task;
    }
}
