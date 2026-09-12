package Model;

import Enums.Size;

public class LockerCell {
    private String id;
    private Size size;
    private boolean occupied;
    private Package currentPackage;

    public LockerCell(String id, Size size, boolean occupied, Package currentPackage) {
        this.id = id;
        this.size = size;
        this.occupied = occupied;
        this.currentPackage = currentPackage;
    }

    public LockerCell(String c1, Size size) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Package getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(Package currentPackage) {
        this.currentPackage = currentPackage;
    }
}
