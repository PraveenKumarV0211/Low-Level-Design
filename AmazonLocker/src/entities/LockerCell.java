package entities;

import enums.Size;

public class LockerCell {
    private int id;
    private boolean isAvailable;

    public LockerCell(int id, Size size) {
        this.id = id;
        this.isAvailable = true;
        this.size = size;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private Size size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
