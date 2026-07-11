package StrategyPattern;

import Model.Elevator;
import Model.Request;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        int sourceFloor = request.getSource().getFloorNumber();

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor().getFloorNumber() - sourceFloor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = elevator;
            }
        }

        return nearest;
    }
}
