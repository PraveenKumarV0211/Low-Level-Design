package Model;

import Enum.VehicleType;


public class ParkingSlot {
    String id;
    VehicleType type;
    boolean isOccupied;

    public ParkingSlot(String id, VehicleType type, boolean isOccupied) {
        this.id = id;
        this.type = type;
        this.isOccupied = isOccupied;
    }

    public String getId() {
        return id;
    }
    public ParkingSlot(String id, VehicleType type) {
        this(id, type, false);
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}