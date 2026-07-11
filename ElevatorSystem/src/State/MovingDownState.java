package State;

import Model.Elevator;
import Model.Request;

public class MovingDownState implements ElevatorState{
    @Override
    public void handleRequest(Elevator elevator, Request request) {
        elevator.getRequestList().add(request);
    }

    @Override
    public void move(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor().getFloorNumber();
        elevator.getCurrentFloor().setFloorNumber(currentFloor - 1);
        System.out.println("Elevator " + elevator.getId() + " moving down to floor " + (currentFloor - 1));

        boolean shouldStop = false;
        for (Request r : elevator.getRequestList()) {
            if (r.getSource().getFloorNumber() == currentFloor - 1
                    || r.getDestination().getFloorNumber() == currentFloor - 1) {
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
        System.out.println("Elevator " + elevator.getId() + " | Floor: "
                + elevator.getCurrentFloor().getFloorNumber() + " | MOVING DOWN");
    }
}
