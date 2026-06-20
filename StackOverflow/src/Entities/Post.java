package Entities;

import Enums.EventType;
import Enums.VoteType;
import Observer.PostObserver;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Post extends Content {
    private int voteCount = 0;
    private final Map<UUID, VoteType> voters = new ConcurrentHashMap<>();
    private final List<Comment> comments = new CopyOnWriteArrayList<>();
    private final List<PostObserver> observers = new CopyOnWriteArrayList<>();

    public Post(UUID id, String body, User user) {
        super(id, body, user);
    }
    public void addObserver(PostObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(Event event){
        for(PostObserver observer : observers){
            observer.onPostEvent(event);
        }
    }

    public void vote(VoteType voteType, User user) {
        UUID userID = user.getId();
        if (voters.containsKey(userID)) {
            System.out.println("User already voted");
            return;
        }
        voters.put(userID, voteType);
        voteCount += (voteType == VoteType.UPVOTE) ? 1 : -1;

        EventType eventType;
        if (this instanceof Question) {
            eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION);
        } else {
            eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER);
        }
        notifyObservers(new Event(eventType, user, this));
    }
}
