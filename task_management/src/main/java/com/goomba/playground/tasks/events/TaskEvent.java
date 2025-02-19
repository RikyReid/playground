package com.goomba.playground.tasks.events;

public sealed interface TaskEvent permits CreatedTaskEvent, ReassignedTaskEvent {
}
