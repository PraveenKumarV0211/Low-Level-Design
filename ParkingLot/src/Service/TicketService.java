package Service;

import Domain.ParkingSlot;
import Domain.Ticket;
import Domain.Vehicle;
import Repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class TicketService {

    private TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle) {
        Ticket ticket = new Ticket(true,LocalDateTime.now(),parkingSlot.getId(),vehicle.getId());
        ticketRepository.saveticket(ticket);
        return ticket;
    }

    public Ticket getTicketDetails(UUID ticketId) {

        Optional<Ticket> validTicket = ticketRepository.getTicketDetails(ticketId);
        if(validTicket.isEmpty()){
            System.out.println("Ticket Not Found");
            return null;
        }
        Ticket ticket = validTicket.get();
        return ticket;
    }
}
