package com.goomba.playground.tasks.events;

import com.goomba.playground.tasks.TaskDO;

public record CreatedTaskEvent(long id, long createdById, long assigneeId, String name) implements TaskEvent {
    CreatedTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.createdById(), taskDO.assigneeId(), taskDO.name());
    }
}
