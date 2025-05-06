package com.goomba.playground.usermanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    Long id() {
        return id;
    }

    String name() {
        return name;
    }

    String email() {
        return email;
    }

    static User from(String name, String email) {
        var user = new User();
        user.name = name;
        user.email = email;
        return user;
    }
}
