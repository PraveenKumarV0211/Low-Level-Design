package States;

import Model.Inventory;
import Model.Order;
import enums.Ingredients;
import main.CoffeeVendingMachine;

import java.util.Map;

public class DispenseState extends VendingMachineState{

    public DispenseState(CoffeeVendingMachine machine) {
        super(machine);
    }

    @Override
    public void dispense() {
        Order order = machine.getCurrentOrder();
        Inventory inventory = machine.getInventory();

        Map<Ingredients, Integer> required = order.getTotalIngredients();
        if (!inventory.hasEnough(required)) {
            double refund = machine.getPayment();
            machine.resetPayment();
            machine.setCurrentOrder(null);
            machine.setState(new IdleState(machine));
            System.out.println("Insufficient ingredients. Refund: " + refund);
            return;
        }

        inventory.deduct(required);
        double change = machine.getPayment() - order.getTotalCost();

        System.out.println("Dispensing: " + order.getCoffee().getName());
        if (change > 0) {
            System.out.println("Change returned: " + change);
        }

        machine.resetPayment();
        machine.setCurrentOrder(null);
        machine.setState(new IdleState(machine));
    }
}
