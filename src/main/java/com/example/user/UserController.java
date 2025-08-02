package com.example.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/health")
    public String healthCheck() {
        return "User service is healthy!";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "List of users";
    }
}
