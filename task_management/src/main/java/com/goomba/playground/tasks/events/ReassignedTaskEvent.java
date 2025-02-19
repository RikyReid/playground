package com.goomba.playground.tasks.events;

import com.goomba.playground.tasks.TaskDO;

public record ReassignedTaskEvent(long id, long assigneeId) implements TaskEvent {
    public ReassignedTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.assigneeId());
    }
}
