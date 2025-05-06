package com.goomba.playground.audit;

import com.goomba.playground.tasks.domain.model.TaskUser;


public class ModularityBreaker {
    void test() {
        var taskUser = TaskUser.from(1, "me");
        System.out.println(taskUser);
    }
}
