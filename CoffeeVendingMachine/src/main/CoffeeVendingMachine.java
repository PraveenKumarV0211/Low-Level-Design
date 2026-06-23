
package main;

import Model.AddOns;
import Model.Coffee;
import Model.Inventory;
import Model.Order;
import States.IdleState;
import States.VendingMachineState;

public class CoffeeVendingMachine {
    private static CoffeeVendingMachine instance;

    private VendingMachineState state;
    private Inventory inventory;

    public CoffeeVendingMachine() {
        this.inventory = new Inventory();
        this.state = new IdleState(this);
        this.currentPayment = 0;
    }


    private Coffee coffee;
    private Order currentOrder;
    private int currentPayment = 0;

    public static synchronized CoffeeVendingMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeVendingMachine();
        }
        return instance;
    }


    public void selectDrink(Coffee coffee) {
        state.selectDrink(coffee);
    }

    public void addAddOn(AddOns addOn) {
        state.addAddOn(addOn);
    }

    public void insertMoney(double amount) {
        state.insertMoney(amount);
    }

    public void dispense() {
        state.dispense();
    }

    public void cancel() {
        state.cancel();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

    public double getPayment() {
        return currentPayment;
    }

    public void addPayment(double amount) {
        this.currentPayment += amount;
    }

    public void resetPayment() {
        this.currentPayment = 0;
    }
}



