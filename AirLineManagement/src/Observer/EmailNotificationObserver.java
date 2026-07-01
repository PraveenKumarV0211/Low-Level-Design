package Observer;

import Entities.Passenger;
import Enums.FlightStatus;

import java.util.List;

public class EmailNotificationObserver implements FlightObserver {
    private String passengerName;
    private String email;

    public EmailNotificationObserver(String passengerName, String email) {
        this.passengerName = passengerName;
        this.email = email;
    }

    @Override
    public void update(String flightName, FlightStatus status) {
        System.out.println("Email to " + email + ": Flight " + flightName + " is now " + status);
    }
}