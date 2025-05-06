package com.goomba.playground.tasks.application.createtask;

import com.goomba.playground.tasks.domain.model.TaskUser;

public record CreateTaskValues(TaskUser createdBy, TaskUser assignee, String name) {
}
