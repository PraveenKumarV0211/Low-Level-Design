package Entities;


import Enums.EventType;

import java.util.*;

public class Question extends Post {
    String title;
    Set<Tag> tags;
    List<Answer> answers = new ArrayList<Answer>();
    Answer acceptedAnswer;

    public Question(UUID id, String body, User user) {
        super(id, body, user);
        this.title = "Question";
        this.tags = new HashSet<Tag>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public synchronized void acceptAnswer(Answer answer) {
        if (this.acceptedAnswer != null) return;
        if (this.author.getId().equals(answer.author.getId())) return;
        acceptedAnswer = answer;
        answer.setIsaccepted(true);
        notifyObservers(new Event(EventType.ACCEPT_ANSWER, answer.author, answer));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
