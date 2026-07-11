package State;

import Model.Elevator;
import Model.Request;

public interface ElevatorState {
    void handleRequest(Elevator elevator, Request request);
    void move(Elevator elevator);
    void display(Elevator elevator);
}
