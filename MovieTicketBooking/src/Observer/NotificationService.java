package Observer;

import Entities.Show;

public class NotificationService implements SeatAvailabilityObserver {
    @Override
    public void onSeatUpdate(Show show, int availableCount) {
        if (availableCount <= 5 && availableCount > 0) {
            System.out.println("[NOTIFICATION] Hurry! Only " + availableCount
                    + " seats left for " + show.getMovie().getTitle());
        } else if (availableCount == 0) {
            System.out.println("[NOTIFICATION] " + show.getMovie().getTitle() + " is now SOLD OUT!");
        }
    }
}

