package com.goomba.playground.tasks;

import com.goomba.playground.CommandHandler;
import com.goomba.playground.tasks.events.CreatedTaskEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateTaskCommandHandler implements CommandHandler<CreateTaskCommand, TaskDO> {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    CreateTaskCommandHandler(TaskRepository taskRepository,
                             UserRepository userRepository,
                             ApplicationEventPublisher eventPublisher) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    @Override
    public TaskDO process(CreateTaskCommand createTaskCommand) {
        validateName(createTaskCommand);
        var task = createTask(createTaskCommand);
        var taskDO =  new TaskDO(task);
        publishEvent(taskDO);
        return taskDO;
    }

    private Task createTask(CreateTaskCommand createTaskCommand) {
        var values = values(createTaskCommand);
        var task = Task.from(values);
        return taskRepository.save(task);
    }

    private void validateName(CreateTaskCommand createTaskCommand) {
        if (taskRepository.existsByName(createTaskCommand.name())) {
            throw new ExistingNameException();
        }
    }

    private CreateTaskValues values(CreateTaskCommand command) {
        var assignee = findUser(command.assigneeId());
        var createdBy = findUser(command.createdById());
        return new CreateTaskValues(createdBy, assignee, command.name());
    }

    private TaskUser findUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    private void publishEvent(TaskDO taskDO) {
        var event = new CreatedTaskEvent(taskDO);
        eventPublisher.publishEvent(event);
    }
}
