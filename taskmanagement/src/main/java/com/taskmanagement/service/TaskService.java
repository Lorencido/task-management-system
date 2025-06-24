package com.taskmanagement.service;

import com.taskmanagement.model.Task;
import com.taskmanagement.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTask(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());

            return repo.save(task);
        }
        return null;
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
