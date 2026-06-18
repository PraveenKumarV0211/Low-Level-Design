package Adapter;

import Domain.Ticket;

import java.util.UUID;

public interface PaymentInterface {
    public boolean pay(UUID ticketId, Double amount);
}
