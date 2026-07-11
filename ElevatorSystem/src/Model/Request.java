package Model;

public class Request {
    private Floor source;
    private Direction direction;
    private Floor destination;

    public Request(Floor source, Direction direction, Floor destination) {
        this.source = source;
        this.direction = direction;
        this.destination = destination;
    }

    public Floor getSource() {
        return source;
    }

    public void setSource(Floor source) {
        this.source = source;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Floor getDestination() {
        return destination;
    }

    public void setDestination(Floor destination) {
        this.destination = destination;
    }
}
