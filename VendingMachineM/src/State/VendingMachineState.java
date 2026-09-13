package State;

import Model.VendingMachine;

public interface VendingMachineState {

    public void insertMoney(VendingMachine machine,double money);
    public void selectDrink(VendingMachine machine,String coffee);
    public void dispenseDrink(VendingMachine machine);
    public void cancelDrink(VendingMachine machine);

}
