package com.goomba.playground.tasks.events;

import com.goomba.playground.tasks.TaskDO;
import com.goomba.playground.tasks.UserDO;

public record CreatedTaskEvent(long id, long createdById, UserDO assignee, String name) implements TaskEvent {
    public CreatedTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.createdById(), taskDO.assignee(), taskDO.name());
    }
}
