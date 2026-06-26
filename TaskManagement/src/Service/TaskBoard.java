package Service;

import Entities.Task;
import Strategy.FilterStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskBoard {
    String id;
    String name;
    Map<String, Task> tasks;


    public Task getTask(String taskId) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found: " + taskId);
        }
        System.out.println("[TaskBoard] getTask: found task='" + task.getTitle() + "' in board='" + name + "'");
        return task;
    }
    public List<Task> getFilteredTasks(List<FilterStrategy> filters) {
        List<Task> result = new ArrayList<>(tasks.values());
        for (FilterStrategy filter : filters) {
            result = filter.filterTasks(result);
        }
        System.out.println("[TaskBoard] getFilteredTasks: " + result.size() + " task(s) matched in board='" + name + "'");
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

    public TaskBoard(String id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new HashMap<>();
        System.out.println("[TaskBoard] Created board -> id=" + id + ", name='" + name + "'");
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        System.out.println("[TaskBoard] addTask: task='" + task.getTitle() + "' added to board='" + name + "'");
    }

    public void removeTask(String taskID){
        System.out.println("[TaskBoard] removeTask: taskId=" + taskID + " removed from board='" + name + "'");
        tasks.remove(taskID);
    }

    public List<Task> filterTask(List<FilterStrategy> filters){
        List<Task> result = new ArrayList<>(tasks.values());
        for(FilterStrategy strategy: filters){
            result = strategy.filterTasks(result);
        }
        System.out.println("[TaskBoard] filterTask: " + result.size() + " task(s) matched in board='" + name + "'");
        return result;
    }
}
