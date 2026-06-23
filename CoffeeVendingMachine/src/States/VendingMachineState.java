package States;

import Model.AddOns;
import Model.Coffee;
import main.CoffeeVendingMachine;

public abstract class VendingMachineState {

    protected final CoffeeVendingMachine machine;

    public VendingMachineState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    public void selectDrink(Coffee coffee) {
        throw new IllegalStateException("Cannot select drink in current state");
    }

    public void addAddOn(AddOns addOns){
        throw new IllegalStateException("Cannot select AddOns in current state");
    }

    public void insertMoney(double amount){
        throw new IllegalStateException("Cannot insert money in current state");
    }
    public void dispense(){
        throw new IllegalStateException("Cannot dispense drink in current state");
    }

    public void cancel(){
        throw new IllegalStateException("Cannot cancel drink in current state");
    }
}
