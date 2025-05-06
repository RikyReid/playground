package com.goomba.playground.tasks.infrastructure.controller;

import com.goomba.playground.tasks.application.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tasks")
class TaskController {
    private final CreateTaskCommandHandler createTaskCommandHandler;
    private final FindTaskRequestHandler findTaskHandler;
    private final ReassignTaskCommandHandler reassignTaskCommandHandler;

    TaskController(CreateTaskCommandHandler createTaskCommandHandler,
                   FindTaskRequestHandler findTaskHandler,
                   ReassignTaskCommandHandler reassignTaskCommandHandler) {
        this.createTaskCommandHandler = createTaskCommandHandler;
        this.findTaskHandler = findTaskHandler;
        this.reassignTaskCommandHandler = reassignTaskCommandHandler;
    }

    @GetMapping("/{taskId}")
    TaskDO getTask(@PathVariable("taskId") long taskId) {
        return findTaskHandler.process(taskId);
    }

    @PostMapping
    TaskDO createTask(@Validated @RequestBody CreateTaskCommand command) {
        return createTaskCommandHandler.process(command);
    }

    @PutMapping("/{taskId}/reassign")
    TaskDO reassignTask(@PathVariable("taskId") long taskId,
                        @RequestParam("assigneeId") long assignId) {
        var command = new ReassignTaskCommand(taskId, assignId);
        return reassignTaskCommandHandler.process(command);

    }
}
