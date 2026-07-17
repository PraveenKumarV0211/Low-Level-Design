package Entities;

public class Player {
    private String name;
    private int id;
    private int currentPosition;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
