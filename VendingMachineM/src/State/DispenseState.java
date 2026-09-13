package State;

import Model.VendingMachine;

public class DispenseState implements VendingMachineState{
    @Override
    public void insertMoney(VendingMachine machine, double money) {
        System.out.println("You can not enter money now");
    }

    @Override
    public void selectDrink(VendingMachine machine, String coffee) {
        System.out.println("You can not enter select coffee now");
    }

    @Override
    public void dispenseDrink(VendingMachine machine) {
        System.out.println("Drink is getting despensed");
        machine.reset();
        machine.setMachineState(new IdleState());
    }

    @Override
    public void cancelDrink(VendingMachine machine) {
        System.out.println("you cannot cancel now");
    }
}
