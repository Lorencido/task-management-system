package com.taskmanagement.controller;

import com.taskmanagement.dto.TaskDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.taskmanagement.model.Task;
import com.taskmanagement.service.TaskService;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDTO> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return service.getTask(id);
    }

    @PostMapping
    public TaskDTO create(@RequestBody @Valid TaskDTO taskDTO) {
        return service.createTask(taskDTO);
    }

    @PutMapping("{id}")
    public TaskDTO update(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO) {
        return service.updateTask(id, taskDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
