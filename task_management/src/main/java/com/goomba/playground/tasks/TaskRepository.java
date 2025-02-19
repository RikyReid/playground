package com.goomba.playground.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("""
            SELECT new com.goomba.playground.tasks.TaskDO(t.id, t.createdById,
            new com.goomba.playground.tasks.UserDO(u.id, u.name), t.name)
            FROM Task t JOIN t.assignee u WHERE t.id = :id
            """)
    Optional<TaskDO> findTaskById(long id);

    boolean existsByName(String name);
}
