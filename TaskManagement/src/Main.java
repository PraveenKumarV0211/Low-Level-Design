import Entities.Task;
import Entities.User;
import Enums.Priority;
import Enums.TaskStatus;
import Service.TaskBoard;
import Service.TaskManager;
import Strategy.PriorityFilter;
import Strategy.StatusFilter;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Task Management System =====");

        TaskManager manager = new TaskManager();

        System.out.println("\n--- Creating Users ---");
        User alice = new User("u1", "Alice", "alice@example.com");
        User bob = new User("u2", "Bob", "bob@example.com");
        manager.addUser(alice);
        manager.addUser(bob);

        System.out.println("\n--- Creating Board ---");
        manager.createBoard(new TaskBoard("b1", "Sprint 1"));

        System.out.println("\n--- Creating Task ---");
        Task task = manager.createTask("b1",
                new Task.Builder("t1", "Fix login bug", alice)
                        .description("Login fails on mobile")
                        .priority(Priority.HIGH)
                        .dueDate(LocalDate.of(2026, 7, 1))
                        .assignee(bob));

        System.out.println("\n--- Changing Task Status ---");
        manager.changeStatus("b1", "t1", TaskStatus.IN_PROGRESS, bob);

        System.out.println("\n--- Searching Tasks (HIGH priority + IN_PROGRESS) ---");
        List<Task> highPriority = manager.searchTasks("b1", List.of(
                new PriorityFilter(Priority.HIGH),
                new StatusFilter(TaskStatus.IN_PROGRESS)
        ));

        System.out.println("\n===== Final Results =====");
        System.out.println("Tasks matching HIGH priority + IN_PROGRESS: " + highPriority.size());
        for (Task t : highPriority) {
            System.out.println("  Task: '" + t.getTitle() + "' | Status: " + t.getStatus()
                    + " | Priority: " + t.getPriority()
                    + " | Assignee: " + (t.getAssignee() != null ? t.getAssignee().getName() : "none")
                    + " | Due: " + t.getDueDate());
        }
    }
}