package com.goomba.playground.usermanagement;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SimpleCreateUserHandler {
    private final UserRespository userRespository;
    private ApplicationEventPublisher applicationEventPublisher;

    SimpleCreateUserHandler(UserRespository userRespository,
                            ApplicationEventPublisher applicationEventPublisher) {
        this.userRespository = userRespository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public UserDO createUser(String name, String email) {
        var user = User.from(name, email);
        user = userRespository.save(user);
        publishEvent(user);
        return new UserDO(user);
    }

    private void publishEvent(User user) {
        var event = new UserCreatedEvent(user);
        applicationEventPublisher.publishEvent(event);
    }
}
