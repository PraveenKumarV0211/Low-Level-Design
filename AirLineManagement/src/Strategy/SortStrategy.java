package Strategy;

import Entities.Flight;

import java.util.List;

public interface SortStrategy {
    public void sort(List<Flight> flights);
}
