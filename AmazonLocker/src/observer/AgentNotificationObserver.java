package observer;

import entities.Reservation;

public class AgentNotificationObserver implements ExpiryObserver {
    @Override
    public void onReservationExpired(Reservation reservation) {
        System.out.println("Notifying agent: Pick up expired package " + reservation.getPackageId()
                + " from locker " + reservation.getLockerID() + ", cell " + reservation.getLockerCellID());
    }
}