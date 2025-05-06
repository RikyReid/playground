package com.goomba.playground.tasks.application;

public record CreateTaskCommand(long createdById,
                         long assigneeId,
                         String name) {
}
