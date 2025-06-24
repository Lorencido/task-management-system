package com.taskmanagement.repo;

import com.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//Gives the Task model CRUD operations like findById, deleById and more
public interface TaskRepository extends JpaRepository<Task, Long> {

}
