import Controller.ElevatorController;
import Model.Elevator;
import Model.Floor;
import Model.Request;
import Model.Direction;
import State.IdleState;
import StrategyPattern.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create floors 0-5
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            floors.add(new Floor(i, false, false));
        }

        // create 2 elevators, both idle at floor 0
        Elevator elevator1 = new Elevator(1, 10, floors.get(0), new IdleState());
        Elevator elevator2 = new Elevator(2, 10, floors.get(0), new IdleState());

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(elevator1);
        elevators.add(elevator2);

        // controller with nearest elevator strategy
        ElevatorController controller = new ElevatorController(elevators, new StrategyPattern.NearestElevatorStrategy());

        // request 1: someone on floor 2 wants to go to floor 5
        Request req1 = new Request(floors.get(2), Direction.UP, floors.get(5));
        controller.submitRequest(req1);

        // request 2: someone on floor 4 wants to go to floor 1
        Request req2 = new Request(floors.get(4), Direction.DOWN, floors.get(1));
        controller.submitRequest(req2);

        // simulate 10 steps
        for (int i = 1; i <= 10; i++) {
            System.out.println("--- Step " + i + " ---");
            controller.step();
            controller.displayStatus();
        }
    }
}
/*

N floor with M elevator

User press up or down buttom

enter elevator - > destination floor

system dispatch optimal nearest elevator

Entities -> Direction (enum)

Request -> floor , destination floor, direction

elevator -> id,List<Request> ,currentfloor,direction, state
floor -> floor number uo/down buttons
elevatorController -> handle elevator operations






 */