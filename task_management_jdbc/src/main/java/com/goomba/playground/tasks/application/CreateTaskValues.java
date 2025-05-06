package com.goomba.playground.tasks.application;

import com.goomba.playground.tasks.domain.model.TaskUser;

public record CreateTaskValues(TaskUser createdBy, TaskUser assignee, String name) {
}
