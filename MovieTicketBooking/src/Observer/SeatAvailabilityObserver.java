package Observer;

import Entities.Show;
import FactoryPattern.Seat;

public interface SeatAvailabilityObserver {
    void onSeatUpdate(Show show,int availableCount);
}
