package Domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private UUID vehicleId;
    private UUID slotId;
    private LocalDateTime creationDate;
    private boolean isActive;

    public Ticket(boolean isActive, LocalDateTime creationDate, UUID slotId, UUID vehicleId) {
        this.id = UUID.randomUUID();
        this.isActive = isActive;
        this.creationDate = creationDate;
        this.slotId = slotId;
        this.vehicleId = vehicleId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
