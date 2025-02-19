package com.goomba.playground;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final EventPublisher publisher;

    public MyController(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/test")
    String test() {
   publisher.publishEvent();
        return "Test works...";
    }
}
