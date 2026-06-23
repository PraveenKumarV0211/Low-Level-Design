package States;

import main.CoffeeVendingMachine;

public class PaymentPendingState extends VendingMachineState {

    public PaymentPendingState(CoffeeVendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertMoney(double amount) {
        machine.addPayment(amount);
        double totalCost = machine.getCurrentOrder().getTotalCost();
        System.out.println("Inserted: " + amount + " | Total paid: " + machine.getPayment() + " | Required: " + totalCost);
        if (machine.getPayment() >= totalCost) {
            machine.setState(new DispenseState(machine));
            machine.dispense();
        }
    }

    @Override
    public void cancel() {
        double refund = machine.getPayment();
        machine.resetPayment();
        machine.setCurrentOrder(null);
        machine.setState(new IdleState(machine));
        System.out.println("Order cancelled. Refund: " + refund);


    }
}
