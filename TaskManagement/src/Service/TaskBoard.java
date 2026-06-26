package Service;

import Entities.Task;
import Strategy.FilterStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskBoard {
    String id;
    String name;
    Map<String, Task> tasks;

    public TaskBoard(String id, String name, Map<String, Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(String taskID){
        tasks.remove(taskID);
    }

    public List<Task> filterTask(List<FilterStrategy> filters){
        List<Task> result = new ArrayList<>(tasks.values());
        for(FilterStrategy strategy: filters){
            result = strategy.filterTasks(result);
        }
        return result;
    }
}
