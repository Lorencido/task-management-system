package com.taskmanagement.controller;

import com.taskmanagement.model.User;
import com.taskmanagement.service.JwtService;
import com.taskmanagement.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> payload) {
        User user = userService.register(payload.get("username"), payload.get("password"));
        return Map.of("message", "User created", "username", user.getUsername());
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> payload) {
        User user = userService.findByUsername(payload.get("username"));
        if (!new org.springframework
                .security
                .crypto
                .bcrypt
                .BCryptPasswordEncoder()
                .matches(payload.get("password"), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getUsername());
        return Map.of("token", token);
    }
}
