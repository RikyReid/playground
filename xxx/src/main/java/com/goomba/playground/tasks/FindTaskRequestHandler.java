package com.goomba.playground.tasks;

import org.springframework.stereotype.Component;

@Component
class FindTaskRequestHandler implements CommandHandler<Long, TaskDO> {
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
