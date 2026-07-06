package enums;

public enum Size {
    SMALL(1), MEDIUM(2), LARGE(3);
    int capacity;

    Size(int size) {
        this.capacity = size;
    }
}
