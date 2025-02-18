package com.goomba.playground.tasks;

import com.goomba.playground.EventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class CreateTaskCommandHandler implements CommandHandler<CreateTaskCommand, TaskDO> {
    private final TaskRepository taskRepository;
    private final ApplicationEventPublisher eventPublisher;

    CreateTaskCommandHandler(TaskRepository taskRepository,
                             ApplicationEventPublisher eventPublisher) {
        this.taskRepository = taskRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public TaskDO process(CreateTaskCommand createTaskCommand) {
        validateName(createTaskCommand);
        var task = createTask(createTaskCommand);
        var taskDO =  new TaskDO(task);
        publishEvent(taskDO);
        return taskDO;
    }

    private Task createTask(CreateTaskCommand createTaskCommand) {
        var task = Task.from(createTaskCommand);
        return taskRepository.save(task);
    }

    private void validateName(CreateTaskCommand createTaskCommand) {
        if (taskRepository.existsByName(createTaskCommand.name())) {
            throw new ExistingNameException();
        }
    }

    private void publishEvent(TaskDO taskDO) {
        var event = new CreateTaskEvent(taskDO);
        eventPublisher.publishEvent(event);
    }
}
