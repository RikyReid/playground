package com.goomba.playground.tasks.application;

public record ReassignTaskCommand(long taskId, long assigneeId) {
}
