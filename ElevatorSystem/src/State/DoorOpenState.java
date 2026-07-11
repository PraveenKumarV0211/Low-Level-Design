package State;

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
        int currentFloor = elevator.getCurrentFloor().getFloorNumber();
        System.out.println("Elevator " + elevator.getId() + " doors open at floor " + currentFloor);
        Iterator<Request> it = elevator.getRequestList().iterator();
        while (it.hasNext()) {
            Request r = it.next();
            if (r.getDestination().getFloorNumber() == currentFloor) {
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
            int target = r.getDestination().getFloorNumber();
            int source = r.getSource().getFloorNumber();
            if (target > currentFloor || source > currentFloor) hasUp = true;
            if (target < currentFloor || source < currentFloor) hasDown = true;
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
        System.out.println("Elevator " + elevator.getId() + " | Floor: "
                + elevator.getCurrentFloor().getFloorNumber() + " | DOOR OPEN");
    }
}
