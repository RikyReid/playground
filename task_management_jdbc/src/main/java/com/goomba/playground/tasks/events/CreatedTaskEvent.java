package com.goomba.playground.tasks.events;

import com.goomba.playground.tasks.application.TaskDO;
import com.goomba.playground.tasks.application.TaskUserDO;

public record CreatedTaskEvent(long id, TaskUserDO createdBy, TaskUserDO assignee, String name) implements TaskEvent {
    public CreatedTaskEvent(TaskDO taskDO) {
        this(taskDO.id(), taskDO.createdBy(), taskDO.assignee(), taskDO.name());
    }
}
