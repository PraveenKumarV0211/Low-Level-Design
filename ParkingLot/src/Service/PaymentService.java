package Service;

import Adapter.PaymentInterface;
import Domain.Ticket;

public class PaymentService {

    private PaymentInterface paymentInterface;

    public PaymentService(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }

    public boolean makePayment(Ticket ticket,Double fee){
        boolean result = paymentInterface.pay(ticket.getId(),fee);
        return result;
    }
}
