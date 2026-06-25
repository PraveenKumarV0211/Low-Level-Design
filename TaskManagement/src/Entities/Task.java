package Entities;

import Enums.Priority;
import Enums.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private String id;
    private String title;
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
