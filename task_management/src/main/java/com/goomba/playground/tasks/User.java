package com.goomba.playground.tasks;

import jakarta.persistence.*;

@Entity
@Table(name = "task_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    long id() {
        return id;
    }

    String name() {
        return name;
    }

    static User from(String name) {
        var user = new User();
        user.name = name;
        return user;
    }
}
