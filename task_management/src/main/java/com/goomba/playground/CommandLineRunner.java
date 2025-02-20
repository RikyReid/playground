package com.goomba.playground;

import com.goomba.playground.tasks.CreateTaskCommand;
import com.goomba.playground.tasks.CreateTaskCommandHandler;
import com.goomba.playground.usermanagement.SimpleCreateUserHandler;
import org.springframework.stereotype.Component;

@Component
class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CreateTaskCommandHandler createTaskCommandHandler;
    private final SimpleCreateUserHandler simpleCreateUserHandler;

    CommandLineRunner(CreateTaskCommandHandler createTaskCommandHandler,
                      SimpleCreateUserHandler simpleCreateUserHandler) {
        this.createTaskCommandHandler = createTaskCommandHandler;
        this.simpleCreateUserHandler = simpleCreateUserHandler;
    }

    @Override
    public void run(String... args) throws Exception {
        var unassigned = simpleCreateUserHandler.createUser("Unassigned", "unassigned@inernal.com");
        var mario = simpleCreateUserHandler.createUser("mario", "mario@supermariobros.com");
        var luigi = simpleCreateUserHandler.createUser("luigi", "luigi@supermariobros.com");
        addTask(mario.id(), luigi.id(), "Task 1");
        addTask(luigi.id(), mario.id(), "Task 2");
    }

    private void addTask(long createdById, long assigneeId, String name) {
        var createTaskCommand = new CreateTaskCommand(createdById, assigneeId, name);
        createTaskCommandHandler.process(createTaskCommand);
    }
}
