package Model;

import Enums.Colours;

public class Player {
    private final int id;
    private final String name;
    private final Colours coinColour;

    public Player(int id, String name, Colours coinColour) {
        this.id = id;
        this.name = name;
        this.coinColour = coinColour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Colours getCoinColour() {
        return coinColour;
    }

    @Override
    public String toString() {
        return name + "(" + coinColour + ")";
    }
}