package Service;

import Entities.Task;
import Entities.User;
import Enums.TaskStatus;
import Strategy.FilterStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private Map<String,TaskBoard> boards;
    private Map<String, User> users;

    public TaskManager(){
        this.boards = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void addUser(User user){
        users.put(user.getId(), user);
        System.out.println("[TaskManager] addUser: user='" + user.getName() + "' (id=" + user.getId() + ") added");
    }

    public void createBoard(TaskBoard board){
        boards.put(board.getId(), board);
        System.out.println("[TaskManager] createBoard: board='" + board.getName() + "' (id=" + board.getId() + ") created");
    }

    private TaskBoard getBoard(String boardId) {
        TaskBoard board = boards.get(boardId);
        if (board == null) {
            throw new IllegalArgumentException("Board not found: " + boardId);
        }
        System.out.println("[TaskManager] getBoard: found board='" + board.getName() + "'");
        return board;
    }

    public Task createTask(String boardID, Task.Builder builder){
        TaskBoard board = getBoard(boardID);
        Task task = builder.build();
        board.addTask(task);
        System.out.println("[TaskManager] createTask: task='" + task.getTitle() + "' created on board='" + board.getName() + "'");
        return task;
    }

    public void deleteTask(String boardId, String taskId) {
        System.out.println("[TaskManager] deleteTask: taskId=" + taskId + " from boardId=" + boardId);
        getBoard(boardId).removeTask(taskId);
    }

    public List<Task> searchTasks(String boardId, List<FilterStrategy> filters) {
        System.out.println("[TaskManager] searchTasks: boardId=" + boardId + " with " + filters.size() + " filter(s)");
        List<Task> results = getBoard(boardId).filterTask(filters);
        System.out.println("[TaskManager] searchTasks result: " + results.size() + " task(s) found");
        results.forEach(t -> System.out.println("  -> task='" + t.getTitle() + "', status=" + t.getStatus() + ", priority=" + t.getPriority()));
        return results;
    }

    public void changeStatus(String boardId, String taskId,
                             TaskStatus newStatus, User changedBy) {
        Task task = getBoard(boardId).getTask(taskId);
        TaskStatus oldStatus = task.getStatus();
        task.transitionStatus(newStatus, changedBy);
        System.out.println("[TaskManager] changeStatus: Email to " + changedBy.getEmail()
                + ": Task '" + task.getTitle() + "' moved from " + oldStatus + " to " + newStatus);
    }
}
