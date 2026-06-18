package Service;

import Domain.ParkingSlot;
import Domain.Vehicle;
import Repository.SlotRepository;

import java.util.Optional;
import java.util.UUID;

public class SlotService {
    private SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public Optional<ParkingSlot> allocateParkingSlot(Vehicle.VehicleType type, String licensePlate) {
        Optional<ParkingSlot> pt = slotRepository.allocateSlot(type);
        if (pt.isEmpty()) {
            System.out.println("Slot not found");
        }
        return pt;
    }

    public void releaseSlot(UUID slotId) {
        slotRepository.releaseSlot(slotId);
    }
}
