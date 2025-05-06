package com.goomba.playground.audit;

import com.goomba.playground.tasks.events.CreatedTaskEvent;
import com.goomba.playground.tasks.events.ReassignedTaskEvent;
import com.goomba.playground.tasks.events.TaskEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogger {

    @EventListener
    public void listener(TaskEvent event) {
        switch (event) {
            case CreatedTaskEvent e -> log.info("CREATED: " + e.id());
            case ReassignedTaskEvent r -> log.info("REASSIGNED: task "  + r.id() + " to user " + r.assigneeId());
        }
    }
}
