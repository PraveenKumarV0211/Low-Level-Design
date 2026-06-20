package Entities;

import java.util.UUID;

public class Answer extends Post {

    boolean isaccepted = false;

    public Answer(String body, User user) {
        super(UUID.randomUUID(), body, user);
    }

    public void setIsaccepted(boolean isaccepted) {
        this.isaccepted = isaccepted;
    }
    public boolean isAccepted() {
        return isaccepted;
    }
}
