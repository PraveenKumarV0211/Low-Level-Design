package Strategy;

public class CreditCardPayment implements PaymentStrategy{

    private Long cardNumber;
    private int cvv;
    private String name;

    public CreditCardPayment(Long cardNumber, int cvv, String name) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.name = name;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("payment done through card");
        return false;
    }
}
