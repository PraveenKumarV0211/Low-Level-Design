package States;
import src.Main;
import src.TrafficLight;

public interface SignalState {
    public void handle(TrafficLight light);
    String getName();
}
