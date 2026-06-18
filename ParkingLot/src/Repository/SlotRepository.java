package Repository;

import Domain.ParkingSlot;
import Domain.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class SlotRepository {
    Map<UUID,ParkingSlot> slots = new HashMap<>();

    public void saveParkinglot(ParkingSlot parkingSlot) {
        slots.put(parkingSlot.getId(), parkingSlot);
    }

    public Optional<ParkingSlot> allocateSlot(Vehicle.VehicleType type){
        for(ParkingSlot pt : slots.values()){
            if(pt.getSlotType() == type && !pt.isOccupied()){
                pt.setOccupied(true);
                return Optional.of(pt);
            }
        }
        return Optional.empty();
    }

    public void releaseSlot(UUID slotId) {
        ParkingSlot parkingSlot = slots.get(slotId);
        if (parkingSlot != null) parkingSlot.setOccupied(false);
    }
}
