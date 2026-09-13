package Strategy;

public class UpiPayment implements PaymentStrategy{

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        return false;
    }
}
