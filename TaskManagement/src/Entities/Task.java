package Entities;

import Enums.Priority;
import Enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    private String description;
    private User creator;
    private User assignee;
    private Priority priority;
    private TaskStatus taskStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate dueDate;

    public Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.taskStatus = TaskStatus.TODO;
        this.priority = builder.priority;
        this.dueDate = builder.dueDate;
        this.creator = builder.creator;
        this.assignee = builder.assignee;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }


    public static class Builder {
        private String id;
        private String title;
        private String description;
        private User creator;
        private User assignee;
        private Priority priority;
        private LocalDate dueDate;

        public Builder(String id, String title, User creator) {
            this.id = id;
            this.title = title;
            this.creator = creator;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder assignee(User assignee) {
            this.assignee = assignee;
            return this;
        }

        public Task build() {
            return new Task(this);
        }

    }

}
