package StatePattern;

import Model.Elevator;
import Model.Request;

public class MovingDownState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, Request request) {
        elevator.getRequestList().add(request);
    }

    @Override
    public void move(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor() - 1;
        elevator.setCurrentFloor(currentFloor);
        System.out.println("Elevator " + elevator.getId() + " moving down to floor " + currentFloor);

        boolean shouldStop = false;
        for (Request request : elevator.getRequestList()) {
            if (request.getDestination() == currentFloor || request.getSource() == currentFloor) {
                shouldStop = true;
                break;
            }
        }

        if (shouldStop) {
            elevator.setElevatorState(new DoorOpenState());
        } else if (elevator.getRequestList().isEmpty()) {
            elevator.setElevatorState(new IdleState());
        }
    }

    @Override
    public void display(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " | Floor: " + elevator.getCurrentFloor() + " | MOVING DOWN");
    }
}