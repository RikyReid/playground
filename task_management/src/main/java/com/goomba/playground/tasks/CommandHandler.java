package com.goomba.playground.tasks;

public interface CommandHandler<T, R> {
    R process(T t);
}
