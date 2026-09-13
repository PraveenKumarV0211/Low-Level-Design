package State;

import Model.VendingMachine;

public class IdleState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine machine, double money) {
        System.out.println("Money added");
        machine.setBalance(machine.getBalance()+money);
        machine.setMachineState(new HasMoneyState());
    }

    @Override
    public void selectDrink(VendingMachine machine, String coffee) {
        System.out.println("Insert money first");
    }

    @Override
    public void dispenseDrink(VendingMachine machine) {
        System.out.println("Insert money first");
    }

    @Override
    public void cancelDrink(VendingMachine machine) {
        System.out.println("Insert money first");
    }
}
