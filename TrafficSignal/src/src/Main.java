package src;

import Enums.Directions;
import States.SignalState;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Intersection intersection = new Intersection();
        for (Directions dir : Directions.values()) {
            intersection.setDuration(dir, "GREEN", 3);
            intersection.setDuration(dir, "YELLOW", 1);
        }
        TrafficSignalController controller = new TrafficSignalController(intersection);
        controller.start();
    }
}