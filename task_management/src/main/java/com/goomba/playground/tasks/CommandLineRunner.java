package com.goomba.playground.tasks;

import org.springframework.stereotype.Component;

@Component
class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CreateTaskCommandHandler createTaskCommandHandler;

    CommandLineRunner(CreateTaskCommandHandler createTaskCommandHandler) {
        this.createTaskCommandHandler = createTaskCommandHandler;
    }

    @Override
    public void run(String... args) throws Exception {
        addTask(1, 2, "Task 1");
        addTask(2, 1, "Task 2");
    }

    private void addTask(long createdById, long assigneeId, String name) {
        var createTaskCommand = new CreateTaskCommand(createdById, assigneeId, name);
        createTaskCommandHandler.process(createTaskCommand);
    }
}
