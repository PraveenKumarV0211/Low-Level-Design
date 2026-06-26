package Strategy;

import Entities.Task;
import Enums.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class StatusFilter implements FilterStrategy {
    private TaskStatus status;

    public StatusFilter(TaskStatus status) {
        this.status = status;
    }

    @Override
    public List<Task> filterTasks(List<Task> tasks) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskStatus() == status) {
                result.add(task);
            }
        }
        return result;
    }
}
