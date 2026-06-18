package Repository;

import Domain.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TicketRepository {
    Map<UUID, Ticket> tickets = new HashMap<>();

    public void saveticket(Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public Optional<Ticket> getTicketDetails(UUID ticketId) {
        Ticket ticket = tickets.get(ticketId);
        return Optional.ofNullable(ticket);
    }
}
