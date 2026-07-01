package Observer;

import Entities.Passenger;
import Enums.FlightStatus;

import java.util.List;

public interface FlightObserver {
    void update(String flightName, FlightStatus status);
}