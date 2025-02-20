package com.goomba.playground.tasks;

public record CreateTaskValues(TaskUser createdBy, TaskUser assignee, String name) {
}
