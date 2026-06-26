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
        System.out.println("[StatusFilter] Filtering " + tasks.size() + " task(s) by status=" + status);
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTaskStatus() == status) {
                result.add(task);
            }
        }
        System.out.println("[StatusFilter] " + result.size() + " task(s) passed status=" + status + " filter");
        return result;
    }
}
