package Service;

import Entities.Flight;
import Strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private SortStrategy sortStrategy;

    public FlightSearch(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public SortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<Flight> searchFlights(List<Flight> flights, String src, String dest){
        List<Flight> result = new ArrayList<>();
        for(Flight flight : flights){
            if (flight.getSource().equals(src) && flight.getDestination().equals(dest)){
                result.add(flight);
            }
        }
        sortStrategy.sort(result);
        return result;
    }
}
