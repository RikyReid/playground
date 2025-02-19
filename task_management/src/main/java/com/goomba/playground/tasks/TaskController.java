package com.goomba.playground.tasks;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tasks")
class TaskController {
    private final CreateTaskCommandHandler createTaskCommandHandler;
    private final FindTaskRequestHandler findTaskHandler;

    TaskController(CreateTaskCommandHandler createTaskCommandHandler,
                   FindTaskRequestHandler findTaskHandler) {
        this.createTaskCommandHandler = createTaskCommandHandler;
        this.findTaskHandler = findTaskHandler;
    }

    @GetMapping("/{taskId}")
    TaskDO getTask(@PathVariable("taskId") long taskId) {
        return findTaskHandler.process(taskId);
    }

    @PostMapping
    TaskDO createTask(@Validated @RequestBody CreateTaskCommand command) {
        return createTaskCommandHandler.process(command);
    }
}
