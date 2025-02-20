package com.goomba.playground.tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "task_user")
class TaskUser {
    @Id
    private Long id;

    private String name;

    long id() {
        return id;
    }

    String name() {
        return name;
    }

    static TaskUser from(long id, String name) {
        var user = new TaskUser();
        user.id = id;
        user.name = name;
        return user;
    }
}
