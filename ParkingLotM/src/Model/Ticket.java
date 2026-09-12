package Model;


import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    String id;
    LocalDateTime entryTime;
    Vehicle vehicle;
    ParkingSlot slot;

    public String getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSlot slot) {
        this.id = UUID.randomUUID().toString();;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.slot = slot;
    }
}
