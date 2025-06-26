package com.taskmanagement.service;

import com.taskmanagement.dto.TaskDTO;
import com.taskmanagement.model.Task;
import com.taskmanagement.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskDTO> getAllTasks() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TaskDTO getTask(Long id) {
        Task task =  repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return toDTO(task);
    }

    public TaskDTO createTask(TaskDTO dto) {
        Task saved = repo.save(fromDTO(dto));
        return toDTO(saved);
    }

    public TaskDTO updateTask(Long id, TaskDTO dto) {
        Task task = repo.findById(id).orElseThrow(() ->new RuntimeException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());

        return toDTO(repo.save(task));
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    //DTO helper functions
    private TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());

        return dto;
    }

    private Task fromDTO(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());

        return task;
    }
}
