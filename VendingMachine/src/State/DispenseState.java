package State;

import Domain.Coin;
import vendingmachine.VendingMachine;

public class DispenseState extends VendingMachineState {
    public DispenseState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        //
    }

    @Override
    public void refund() {
        System.out.println("Currently dispensing. Please wait.");
    }
}
