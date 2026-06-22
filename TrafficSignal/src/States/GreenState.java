package States;

import src.TrafficLight;

public class GreenState implements SignalState{
    @Override
    public void handle(TrafficLight light) {
        System.out.println(light.getDirections() + "-> YELLOW");
        light.setSignalState(new Yellow());
    }

    @Override
    public String getName() {
        return "";
    }
}
