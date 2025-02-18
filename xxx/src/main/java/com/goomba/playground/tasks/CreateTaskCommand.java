package com.goomba.playground.tasks;

record CreateTaskCommand(long createdById,
                         long assigneeId,
                         String name) {

}
