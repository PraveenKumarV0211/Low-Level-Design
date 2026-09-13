package Model;

import Enums.Direction;

public class Request {
    int source;
    int destination;
    Direction direction;

    public Request(int source, int destination, Direction direction) {
        this.source = source;
        this.destination = destination;
        this.direction = direction;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}