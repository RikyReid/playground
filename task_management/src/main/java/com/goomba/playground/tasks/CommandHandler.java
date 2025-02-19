package com.goomba.playground.tasks;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandler<T, R> {
    R process(T command);
}
