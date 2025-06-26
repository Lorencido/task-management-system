package com.taskmanagement.service;

import com.taskmanagement.model.User;
import com.taskmanagement.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    //Method for registering the user, checks for avaliability of username
    // , hashes the password and creates new user
    public User register(String username, String password) {
        if(userRepo.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        String hashedPassword = passwordEncoder.encode(password);
        return userRepo.save(new User(username, hashedPassword));
    }

    // Method for when username is not found and throws exception
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
