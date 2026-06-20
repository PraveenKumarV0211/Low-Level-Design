package Entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private int reputation;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.reputation = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getReputation() {
        return reputation;
    }

    public String getName() {
        return name;
    }

}