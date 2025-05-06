package com.goomba.playground.tasks.infrastructure.persistence;

import com.goomba.playground.tasks.domain.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TaskUser, Long> {
}
