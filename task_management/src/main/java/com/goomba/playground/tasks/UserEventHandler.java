package com.goomba.playground.tasks;

import com.goomba.playground.usermanagement.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class UserEventHandler {
    private static final Logger log = LoggerFactory.getLogger(UserEventHandler.class);
    private final UserRepository userRepository;

    UserEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    void listener(UserCreatedEvent userCreatedEvent) {
        var user = TaskUser.from(userCreatedEvent.id(), userCreatedEvent.name());
        userRepository.save(user);
        log.info("Received user event.");
    }

}
