package com.goomba.playground;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {
    @Test
    void applicationModules() {
        var modules = ApplicationModules.of(PlaygroundApplication.class);
        modules.forEach(System.out::println);
    }

    @Test
    void verifiesModularStructure() {
        ApplicationModules modules = ApplicationModules.of(PlaygroundApplication.class);
        modules.verify();
    }
}
