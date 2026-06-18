import Adapter.StripePaymentAdapter;
import Controller.EntryController;
import Controller.ExitController;
import Domain.ParkingSlot;
import Domain.Vehicle;
import Repository.SlotRepository;
import Repository.TicketRepository;
import Service.PaymentService;
import Service.PricingCalculatorService;
import Service.SlotService;
import Service.TicketService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Setup
        SlotRepository slotRepository = new SlotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        slotRepository.saveParkinglot(new ParkingSlot(Vehicle.VehicleType.CAR,  false, 1));
        slotRepository.saveParkinglot(new ParkingSlot(Vehicle.VehicleType.BIKE, false, 1));
        slotRepository.saveParkinglot(new ParkingSlot(Vehicle.VehicleType.TRUCK, false, 2));

        SlotService slotService = new SlotService(slotRepository);
        TicketService ticketService = new TicketService(ticketRepository);
        PricingCalculatorService pricingService = new PricingCalculatorService();
        PaymentService paymentService = new PaymentService(new StripePaymentAdapter());
        EntryController entryController = new EntryController(slotService, ticketService);
        ExitController exitController = new ExitController(ticketService, slotService, pricingService, paymentService);

        // --- Scenario 1: Normal entry + exit ---
        System.out.println("=== Scenario 1: Entry + Exit ===");
        EntryController.EntrySuccessDTO car1 = entryController.entry(new Vehicle("KA-01-HH-1234", Vehicle.VehicleType.CAR));
        exitController.exitVehicle(car1.getTicketId());

        // --- Scenario 2: Slot freed after exit; re-entry should succeed ---
        System.out.println("\n=== Scenario 2: Re-entry after slot freed ===");
        EntryController.EntrySuccessDTO car2 = entryController.entry(new Vehicle("TN-04-EF-0001", Vehicle.VehicleType.CAR));
        System.out.println(car2 != null ? "Re-entry succeeded" : "Re-entry failed");

        // --- Scenario 3: All slots occupied; entry should fail ---
        System.out.println("\n=== Scenario 3: Slot full ===");
        entryController.entry(new Vehicle("MH-02-AB-5678", Vehicle.VehicleType.CAR)); // no second CAR slot

        // --- Scenario 4: Exit with invalid ticket ID ---
        System.out.println("\n=== Scenario 4: Invalid ticket exit ===");
        exitController.exitVehicle(UUID.randomUUID());

        // --- Scenario 5: Exit already-exited ticket (slot already freed) ---
        System.out.println("\n=== Scenario 5: Double exit same ticket ===");
        exitController.exitVehicle(car2.getTicketId());
        exitController.exitVehicle(car2.getTicketId()); // second exit of same ticket
    }
}