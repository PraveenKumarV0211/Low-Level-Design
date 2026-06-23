package States;

import Model.AddOns;
import main.CoffeeVendingMachine;

public class DrinkSelectedState extends VendingMachineState{

    public DrinkSelectedState(CoffeeVendingMachine machine) {
        super(machine);
    }

    @Override
    public void addAddOn(AddOns addOns){
        machine.getCurrentOrder().addAddOns(addOns);
        System.out.println("Added: " + addOns.getName() + " (+" + addOns.getPrice() + ")");
    }

    @Override
    public void insertMoney(double price){
        machine.addPayment(price);
        double totalCost = machine.getCurrentOrder().getTotalCost();
        System.out.println("Inserted: " + price + " | Total paid: " + machine.getPayment() + " | Required: " + totalCost);
        if(machine.getPayment() >= totalCost){
            machine.setState(new DispenseState(machine));
            machine.dispense();
        }else{
            machine.setState(new PaymentPendingState(machine));
        }
    }

    @Override
    public void cancel() {
        machine.setCurrentOrder(null);
        machine.setState(new IdleState(machine));
        System.out.println("Order cancelled");
    }
}
