package Adapter;

import java.util.UUID;

public class StripePaymentAdapter implements PaymentInterface {


    public StripePaymentAdapter() {

    }

    @Override
    public boolean pay(UUID ticketId, Double amount) {
        System.out.println("Paying " + amount + " for Ticket " + ticketId);
        System.out.println("Payment successful");
        return true;
    }
}
