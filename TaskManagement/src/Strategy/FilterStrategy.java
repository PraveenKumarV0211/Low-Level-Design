package Strategy;

import Entities.Task;

import java.util.List;

public interface FilterStrategy {
    List<Task> filterTasks(List<Task> tasks);
}
