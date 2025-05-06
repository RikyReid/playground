package com.goomba.playground.tasks.application.createtask;

public record CreateTaskCommand(long createdById,
                         long assigneeId,
                         String name) {
}
