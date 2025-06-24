package com.taskmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;

    //Constructors
    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    //Getters and setters
    public String getTitle() {
        return title;
    }
    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
