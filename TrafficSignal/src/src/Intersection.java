package src;

import Enums.Directions;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Intersection {
    private final Map<Directions,TrafficLight> lights;
    private final Map<Directions, Map<String,Integer>> durations;

    public Intersection(){
        lights = new EnumMap<>(Directions.class);
        durations = new EnumMap<>(Directions.class);
        for(Directions dir : Directions.values()){
            lights.put(dir, new TrafficLight(dir));
            Map<String,Integer> d = new HashMap<>();
            d.put("GREEN",30);
            d.put("YELLOW",30);
            durations.put(dir,d);
        }
    }

    public TrafficLight getLight(Directions dir){
        return lights.get(dir);
    }
    public Collection<TrafficLight> getAllLights() { return lights.values(); }

    public int getDuration(Directions dir, String state) {
        return durations.get(dir).get(state);
    }

    public void setDuration(Directions dir, String state, int seconds) {
        durations.get(dir).put(state, seconds);
    }
}
