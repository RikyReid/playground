package com.goomba.applicationerrors.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @GetMapping("/resource-not-found")
    public void resourceNotFound() {
        throw new ResourceNotFoundException("Item not found: 1");
    }

    @GetMapping("/internal-server-error")
    public void internalServerError() throws Exception {
        throw new Exception("Something went bang...");
    }
}
