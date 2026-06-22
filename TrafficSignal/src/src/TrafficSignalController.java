package src;

import Enums.Directions;
import States.GreenState;
import States.RedState;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TrafficSignalController {
    private final Intersection intersection;
    private final List<Directions> order;
    private int currentIndex;
    private final ScheduledExecutorService scheduler;
    private ScheduledFuture<?> currentTask;

    public TrafficSignalController(Intersection intersection){
        this.intersection = intersection;
        this.order = List.of(Directions.values());
        this.currentIndex = 0;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start(){
        // yet to do;
        setAllRed();
        activateGreen(order.get(currentIndex));
    }

    public void setAllRed(){
        for(TrafficLight light : intersection.getAllLights()){
            light.setSignalState(new RedState());
        }
    }

    public void activateGreen(Directions dir){
        TrafficLight light = intersection.getLight(dir);
        light.transition();
        System.out.println(dir + " -> GREEN");
        int greenDuration = intersection.getDuration(dir, "GREEN");
        currentTask = scheduler.schedule(() -> {
            synchronized (this) {
                activateYellow(dir);
            }
        }, greenDuration, TimeUnit.SECONDS);
    }

    private void activateYellow(Directions dir) {
        TrafficLight light = intersection.getLight(dir);
        light.transition();
        int yellowDuration = intersection.getDuration(dir, "YELLOW");
        currentTask = scheduler.schedule(() -> {
            synchronized (this) {
                light.transition();
                System.out.println(dir + " -> RED");
                currentIndex = (currentIndex + 1) % order.size();
                activateGreen(order.get(currentIndex));
            }
        }, yellowDuration, TimeUnit.SECONDS);
    }


}


