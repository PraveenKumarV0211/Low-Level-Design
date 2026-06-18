package Controller;

import Domain.Ticket;
import Domain.Vehicle;
import Service.PaymentService;
import Service.PricingCalculatorService;
import Service.SlotService;
import Service.TicketService;

import java.util.UUID;

public class ExitController {

    private TicketService ticketService;
    private SlotService slotService;
    private PricingCalculatorService pricingService;
    private PaymentService paymentService;

    public ExitController(TicketService ticketService, SlotService slotService, PricingCalculatorService pricingService, PaymentService paymentService) {
        this.ticketService = ticketService;
        this.slotService = slotService;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
    }

    public void exitVehicle(UUID ticketID){

        Ticket ticket = ticketService.getTicketDetails(ticketID);
        if(ticket == null){
            System.out.println("Ticket Not Found");
            return;
        }

        System.out.println("Ticket Exists");
        System.out.println("Slot Id: "+ ticket.getSlotId());
        System.out.println("Vehicle ID: "+ ticket.getVehicleId());

        slotService.releaseSlot(ticket.getSlotId());

        System.out.println("Slot Released");
        double fee = pricingService.getPrice(Vehicle.VehicleType.BIKE); // for demo purpose we are assuming its just bike
        boolean result = paymentService.makePayment(ticket,fee);
        if(result){
            System.out.println("Payment Successful");
        }
    }


}
