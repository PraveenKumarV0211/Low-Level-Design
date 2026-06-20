package Observer;

import Entities.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}
