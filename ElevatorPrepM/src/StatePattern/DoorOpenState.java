package StatePattern;

import Model.Elevator;
import Model.Request;

import java.util.Iterator;

public class DoorOpenState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, Request request) {
        elevator.getRequestList().add(request);
    }

    @Override
    public void move(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor();
        System.out.println("Elevator " + elevator.getId() + " doors open at floor " + currentFloor);

        Iterator<Request> it = elevator.getRequestList().iterator();
        while (it.hasNext()) {
            Request r = it.next();
            if (r.getDestination() == currentFloor) {
                it.remove();
            }
        }

        if (elevator.getRequestList().isEmpty()) {
            elevator.setElevatorState(new IdleState());
            return;
        }

        boolean hasUp = false;
        boolean hasDown = false;
        for (Request r : elevator.getRequestList()) {
            if (r.getDestination() > currentFloor || r.getSource() > currentFloor) hasUp = true;
            if (r.getDestination() < currentFloor || r.getSource() < currentFloor) hasDown = true;
        }

        if (hasUp) {
            elevator.setElevatorState(new MovingUpState());
        } else if (hasDown) {
            elevator.setElevatorState(new MovingDownState());
        } else {
            elevator.setElevatorState(new IdleState());
        }
    }

    @Override
    public void display(Elevator elevator) {
    }
}