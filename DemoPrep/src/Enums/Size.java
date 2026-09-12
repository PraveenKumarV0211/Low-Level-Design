package Enums;

public enum Size {
    SMALL(1), MEDIUM(2), LARGE(3);

    private final int capacity;

    Size(int capacity) { this.capacity = capacity; }

    public int getCapacity() { return capacity; }
}
