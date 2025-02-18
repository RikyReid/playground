package com.goomba.playground.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<TaskDO> findTaskById(long id);

    boolean existsByName(String name);
}
