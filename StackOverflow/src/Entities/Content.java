package Entities;

import java.time.LocalDateTime;
import java.util.UUID;


public abstract class Content {
    protected UUID id;
    protected String body;
    protected User author;
    protected final LocalDateTime localDateTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Content(UUID id, String body, User user) {
        this.id = id;
        this.author = user;
        this.body = body;
        localDateTime = LocalDateTime.now();
    }

}
