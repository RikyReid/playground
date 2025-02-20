package com.goomba.playground.tasks;

public record CreateTaskValues(long createdById, TaskUser assignee, String name) {
}
