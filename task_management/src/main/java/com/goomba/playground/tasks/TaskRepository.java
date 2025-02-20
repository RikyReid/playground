package com.goomba.playground.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("""
            SELECT new com.goomba.playground.tasks.TaskDO(t.id, new com.goomba.playground.tasks.TaskUserDO(c.id, c.name),
            new com.goomba.playground.tasks.TaskUserDO(a.id, a.name), t.name)
            FROM Task t JOIN t.assignee a
            JOIN t.createdBy c
            WHERE t.id = :id
            """)
    Optional<TaskDO> findTaskById(long id);

    boolean existsByName(String name);
}
