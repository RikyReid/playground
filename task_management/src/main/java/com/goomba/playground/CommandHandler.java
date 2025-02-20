package com.goomba.playground;

public interface CommandHandler<T, R> {
    R process(T command);
}
