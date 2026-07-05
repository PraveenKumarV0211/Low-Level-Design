package Strategy;

public class UPIPayment implements PaymentStrategy{

    private String upiNumber;

    public UPIPayment(String upiNumber){
        this.upiNumber = upiNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("payog through UPI Number "+upiNumber );
    }
}
