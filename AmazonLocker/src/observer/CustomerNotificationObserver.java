package observer;

import entities.Reservation;

public class CustomerNotificationObserver implements ExpiryObserver {
    @Override
    public void onReservationExpired(Reservation reservation) {
        System.out.println("Notifying customer: Package " + reservation.getPackageId()
                + " has expired. Contact support for redelivery or refund.");
    }
}