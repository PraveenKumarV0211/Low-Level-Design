import Enums.Direction;
import Model.Elevator;
import Model.Request;
import StatePattern.IdleState;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(1, 1);
        elevator.setElevatorState(new IdleState());

        elevator.getElevatorState().display(elevator);

        // Request: pick up from floor 1, drop at floor 5
        Request req1 = new Request(1, 5, Direction.UP);
        elevator.getElevatorState().handleRequest(elevator, req1);

        for (int i = 0; i < 6; i++) {
            elevator.getElevatorState().display(elevator);
            elevator.getElevatorState().move(elevator);
        }

        // Request: pick up from floor 3, drop at floor 1
        Request req2 = new Request(3, 1, Direction.DOWN);
        elevator.getElevatorState().handleRequest(elevator, req2);

        for (int i = 0; i < 6; i++) {
            elevator.getElevatorState().display(elevator);
            elevator.getElevatorState().move(elevator);
        }

        elevator.getElevatorState().display(elevator);
    }
}