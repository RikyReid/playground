package com.goomba.playground.tasks;

import org.springframework.stereotype.Component;

@Component
class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CreateTaskCommandHandler createTaskCommandHandler;
    private final UserRepository userRepository;

    CommandLineRunner(CreateTaskCommandHandler createTaskCommandHandler,
                      UserRepository userRepository) {
        this.createTaskCommandHandler = createTaskCommandHandler;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var mario = addUser("Mario");
        var luigi = addUser("Luigi");
        addTask(1, 2, "Task 1");
        addTask(2, 1, "Task 2");
    }

    private void addTask(long createdById, long assigneeId, String name) {
        var createTaskCommand = new CreateTaskCommand(createdById, assigneeId, name);
        createTaskCommandHandler.process(createTaskCommand);
    }

    private User addUser(String name) {
        var user = User.from(name);
       return userRepository.save(user);
    }
}
