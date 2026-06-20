package State;

import Domain.Coin;
import vendingmachine.VendingMachine;

public class HasMoneyState extends VendingMachineState {
    public HasMoneyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Amount already received");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("item already selected");
    }

    @Override
    public void dispense() {
        machine.setCurrentState(new DispenseState(machine));
        machine.dispense();
    }

    @Override
    public void refund() {
        machine.refundBalance();
        machine.reset();
        machine.setCurrentState(new IdleState(machine));
    }
}
