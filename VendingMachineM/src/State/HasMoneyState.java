package State;

import Model.VendingMachine;

public class HasMoneyState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine machine, double money) {
        machine.setBalance(machine.getBalance()+money);
    }

    @Override
    public void selectDrink(VendingMachine machine, String coffee) {
        double price = machine.priceOf(coffee);
        if (price > machine.getBalance()){
            System.out.println("amount is tooo low to buy this coffee");
            return;
        }
        System.out.println("Select the drink you want");
        machine.setSelected(coffee);
        machine.setMachineState(new DispenseState());

    }

    @Override
    public void dispenseDrink(VendingMachine machine) {
        System.out.println("You cannot dispense now");
    }

    @Override
    public void cancelDrink(VendingMachine machine) {
        System.out.println("Cancelling order now");
        machine.reset();
        machine.setMachineState(new IdleState());
    }
}
