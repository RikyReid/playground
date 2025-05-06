package com.goomba.playground.tasks.application;

import com.goomba.playground.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class FindTaskRequestHandler implements CommandHandler<Long, TaskDO> {
    private final TaskRepository taskRepository;

    FindTaskRequestHandler(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDO process(Long id) {
        var task = taskRepository.findTaskById(id);
        return task.orElseThrow(ResourceNotFoundException::new);
    }
}
