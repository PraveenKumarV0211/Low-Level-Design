package StrategyPattern;

import Model.Elevator;
import Model.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    Elevator selectElevator(List<Elevator> elevators, Request request);
}
