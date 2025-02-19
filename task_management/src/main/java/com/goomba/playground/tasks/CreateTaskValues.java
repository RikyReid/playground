package com.goomba.playground.tasks;

public record CreateTaskValues(long createdById, User assignee, String name) {
}
