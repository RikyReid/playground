package com.goomba.playground.tasks;

public record ReassignTaskCommand(long taskId, long assigneeId) {
}
