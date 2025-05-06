package com.goomba.playground;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    @EventListener
    public void listener(UserCreatedEvent userCreatedEvent) {
        System.out.println("Received event - " + userCreatedEvent.toString());
    }

}
