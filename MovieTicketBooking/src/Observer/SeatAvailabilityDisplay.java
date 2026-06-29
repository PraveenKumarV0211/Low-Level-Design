package Observer;

import Entities.Show;

public class SeatAvailabilityDisplay implements SeatAvailabilityObserver{
    String displayName;

    public SeatAvailabilityDisplay(String displayName){
        this.displayName = displayName;
    }

    @Override
    public void onSeatUpdate(Show show, int availableCount) {
        System.out.println("[" + displayName + "] Show: " + show.getMovie().getTitle()
                + " | Screen: " + show.getScreen().getName()
                + " | Available: " + availableCount);

    }
}
