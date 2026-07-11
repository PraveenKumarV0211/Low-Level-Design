package State;

import Model.Elevator;
import Model.Request;

public class IdleState implements ElevatorState{

    @Override
    public void handleRequest(Elevator elevator, Request request) {
       int currentFloor = elevator.getCurrentFloor().getFloorNumber();
       int sourceFloor = request.getSource().getFloorNumber();
       elevator.getRequestList().add(request);

       if(sourceFloor > currentFloor){
           elevator.setElevatorState(new MovingUpState());
       } else if (sourceFloor < currentFloor) {
           elevator.setElevatorState(new MovingDownState());
       }
       else{
           elevator.setElevatorState(new IdleState());
       }
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " is idle.");
    }

    @Override
    public void display(Elevator elevator) {
        System.out.println("Elevator " + elevator.getId() + " | Floor: "
                + elevator.getCurrentFloor().getFloorNumber() + " | IDLE");
    }
}
