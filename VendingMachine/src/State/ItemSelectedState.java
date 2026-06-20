package State;

import Domain.Coin;
import vendingmachine.VendingMachine;

public class ItemSelectedState extends VendingMachineState{

    ItemSelectedState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Coin added: "+ coin.getValue());
        int price = machine.getSelectedItem().getPrice();
        if(machine.getBalance() >= price){
            System.out.println("Sufficient money received");
            machine.setCurrentState(new HasMoneyState(machine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        System.out.println("Please Add sufficient funds");
    }

    @Override
    public void refund() {
        machine.reset();;
        machine.setCurrentState(new IdleState(machine));
    }
}
