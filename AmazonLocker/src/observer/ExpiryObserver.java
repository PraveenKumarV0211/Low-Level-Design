package observer;

import entities.Reservation;

public interface ExpiryObserver {
    void onReservationExpired(Reservation reservation);
}