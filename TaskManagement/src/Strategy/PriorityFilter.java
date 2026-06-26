package Strategy;

import Entities.Task;
import Enums.Priority;

import java.util.ArrayList;
import java.util.List;

public class PriorityFilter implements FilterStrategy{

    private Priority priority;
    public PriorityFilter(Priority priority){
        this.priority = priority;
    }

    @Override
    public List<Task> filterTasks(List<Task> tasks) {
        System.out.println("[PriorityFilter] Filtering " + tasks.size() + " task(s) by priority=" + priority);
        List<Task> result = new ArrayList<>();
        for(Task task : tasks){
            if(task.getPriority() == priority){
                result.add(task);
            }
        }
        System.out.println("[PriorityFilter] " + result.size() + " task(s) passed priority=" + priority + " filter");
        return result;
    }
}
