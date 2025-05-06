package com.goomba.playground.tasks.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_user")
public class TaskUser {
    @Id
    private Long id;

    private String name;

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public static TaskUser from(long id, String name) {
        var user = new TaskUser();
        user.id = id;
        user.name = name;
        return user;
    }
}
