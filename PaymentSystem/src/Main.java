import Service.PaymentService;
import Strategy.CreditCardPayment;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService1 = new PaymentService();
        paymentService1.setPaymentStrategy(new CreditCardPayment(91231131238L,988,"Praveen"));
        paymentService1.pay(500);
    }
}