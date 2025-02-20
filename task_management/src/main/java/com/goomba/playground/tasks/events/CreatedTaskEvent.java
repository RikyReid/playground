package com.goomba.playground.tasks.events;

import com.goomba.playground.tasks.TaskDO;
import com.goomba.playground.tasks.TaskUserDO;

public record CreatedTaskEvent(long id, long createdById, TaskUserDO assignee, String name) implements TaskEvent {
    public CreatedTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.createdById(), taskDO.assignee(), taskDO.name());
    }
}
