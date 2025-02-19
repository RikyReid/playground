package com.goomba.playground.tasks;

public record CreateTaskCommand(long createdById,
                         long assigneeId,
                         String name) {

}
