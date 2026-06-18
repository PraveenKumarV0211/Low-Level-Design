package Domain;

import java.util.UUID;
public class Vehicle {
    private UUID id;
    private String licensePlate;
    private VehicleType type;

    public enum VehicleType{
        BIKE,CAR,TRUCK;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Vehicle(String licensePlate, VehicleType type) {
        this.id = UUID.randomUUID();
        this.licensePlate = licensePlate;
        this.type = type;
    }
}
