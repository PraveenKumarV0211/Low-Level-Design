package StatePattern;

import Model.Elevator;
import Model.Request;

public class IdleState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, Request request) {
        elevator.getRequestList().add(request);
        if (elevator.getCurrentFloor() > request.getSource()) {
            elevator.setElevatorState(new MovingDownState());
        } else {
            elevator.setElevatorState(new MovingUpState());
        }
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " is idle.");
    }

    @Override
    public void display(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " | Floor: " + elevator.getCurrentFloor() + " | IDLE");
    }
}