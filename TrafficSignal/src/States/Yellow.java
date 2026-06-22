package States;

import src.TrafficLight;

public class Yellow implements SignalState{
    @Override
    public void handle(TrafficLight light) {
        System.out.println(light.getDirections() + "-> RED");
        light.setSignalState(new RedState());
    }

    @Override
    public String getName() {
        return "";
    }
}
