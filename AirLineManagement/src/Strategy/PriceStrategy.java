package Strategy;

import Entities.Flight;

import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements SortStrategy{

    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getPrice));
    }
}
