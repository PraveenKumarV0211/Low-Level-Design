package src;

import Enums.Directions;
import States.GreenState;
import States.SignalState;

public class TrafficLight {
    private final Directions direction;
    private SignalState signalState;

    public TrafficLight(Directions direction) {
        this.direction = direction;
        this.signalState = new GreenState();
    }

    public void transition(){
        signalState.handle(this);
    }


    public Directions getDirections() {
        return this.direction;
    }

    public void setSignalState(SignalState state) {
        this.signalState = state;
    }

    public SignalState getState() {
        return signalState;
    }

}