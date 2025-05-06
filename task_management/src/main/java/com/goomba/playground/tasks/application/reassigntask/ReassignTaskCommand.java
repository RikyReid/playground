package com.goomba.playground.tasks.application.reassigntask;

public record ReassignTaskCommand(long taskId, long assigneeId) {
}
