package Controller;

import Model.Elevator;
import Model.Request;
import StrategyPattern.ElevatorSelectionStrategy;

import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private ElevatorSelectionStrategy strategy;

    public ElevatorController(List<Elevator> elevators, ElevatorSelectionStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void submitRequest(Request request){
        Elevator selected = strategy.selectElevator(elevators,request);
        System.out.println("Request assigned to Elevator " + selected.getId());
        selected.getElevatorState().handleRequest(selected,request);
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.getElevatorState().move(elevator);
        }
    }

    public void displayStatus() {
        for (Elevator elevator : elevators) {
            elevator.getElevatorState().display(elevator);
        }
    }

}
