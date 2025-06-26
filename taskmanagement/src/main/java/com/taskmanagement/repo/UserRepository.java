package com.taskmanagement.repo;

import com.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Gives the User model CRUD operations like findById, deleById and more
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
