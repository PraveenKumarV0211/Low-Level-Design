package State;

import Domain.Coin;
import vendingmachine.VendingMachine;

public class IdleState extends VendingMachineState {
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item before inserting money");
    }

    @Override
    public void selectItem(String code) {
        if(!machine.getInventory().isAvailable(code)){
            System.out.println("The item is not available right now");
            return;
        }
        machine.setSelectedItemcode(code);

    }

    @Override
    public void dispense() {
        System.out.println("No item selected.");
    }

    @Override
    public void refund() {
        System.out.println("No item selected.");
    }
}
