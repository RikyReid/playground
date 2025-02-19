package com.goomba.playground.tasks;

import com.goomba.playground.tasks.events.CreatedTaskEvent;
import com.goomba.playground.tasks.events.ReassignedTaskEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReassignTaskCommandHandler implements CommandHandler<ReassignTaskCommand, TaskDO>{
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    ReassignTaskCommandHandler(TaskRepository taskRepository,
                               UserRepository userRepository,
                               ApplicationEventPublisher eventPublisher) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    @Override
    public TaskDO process(ReassignTaskCommand command) {
        validateUserExists(command.assigneeId());
        var task = reassignTask(command);

        var taskDO = new TaskDO(task);
        publishEvent(taskDO);
        return taskDO;
    }

    private void validateUserExists(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
    }

    private Task reassignTask(ReassignTaskCommand command) {
        var task = taskRepository.findById(command.taskId())
                .orElseThrow(ResourceNotFoundException::new);
        return task.reassignTask(command.assigneeId());
    }

    private void publishEvent(TaskDO taskDO) {
        var event = new ReassignedTaskEvent(taskDO);
        eventPublisher.publishEvent(event);
    }
}
