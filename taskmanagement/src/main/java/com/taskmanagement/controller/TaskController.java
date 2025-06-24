package com.taskmanagement.controller;

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
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getTask(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.createTask(task);
    }

    @PutMapping("{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
