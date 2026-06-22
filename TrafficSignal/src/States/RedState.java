package States;

import src.TrafficLight;

public class RedState implements SignalState{
    @Override
    public void handle(TrafficLight light) {
        System.out.println(light.getDirections() +  "-> GREEN");
        light.setSignalState(new GreenState());
    }

    @Override
    public String getName() {
        return "";
    }
}
