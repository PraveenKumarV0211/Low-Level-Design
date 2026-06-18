package Controller;

import Domain.ParkingSlot;
import Domain.Ticket;
import Domain.Vehicle;
import Service.SlotService;
import Service.TicketService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class EntryController {

    private SlotService slotService;
    private TicketService ticketService;

    public EntryController(SlotService slotService, TicketService ticketService) {
        this.slotService = slotService;
        this.ticketService = ticketService;
    }

    public EntrySuccessDTO entry(Vehicle vehicle) {
        Vehicle.VehicleType vehicleType = vehicle.getType();
        String lisencePlate = vehicle.getLicensePlate();
        Optional<ParkingSlot> parkingSlot = slotService.allocateParkingSlot(vehicleType, lisencePlate);
        if (parkingSlot.isEmpty()) {
            System.out.println("Parking Slot is  Full");
            return null;
        }
        Ticket ticket = ticketService.generateTicket(parkingSlot.get(), vehicle);
        EntrySuccessDTO entrySuccessDTO = new EntrySuccessDTO(ticket.getId(),lisencePlate,parkingSlot.get().getId());
        return entrySuccessDTO;

    }

    public class EntrySuccessDTO {
        private UUID ticketId;
        private String licensePlate;
        private UUID slotId;
        private LocalDateTime date;
        public EntrySuccessDTO(UUID ticketId, String licensePlate, UUID slotId) {
            this.ticketId = ticketId;
            this.licensePlate = licensePlate;
            this.slotId = slotId;
            this.date = LocalDateTime.now();
        }

        public UUID getTicketId() { return ticketId; }
    }

}
