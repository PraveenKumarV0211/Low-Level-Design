package Model;

import State.IdleState;
import State.VendingMachineState;

public class VendingMachine {
    VendingMachineState machineState;
    double balance = 0;
    String selected = "";

    public VendingMachineState getMachineState() {
        return machineState;
    }

    public void setMachineState(VendingMachineState machineState) {
        this.machineState = machineState;
    }

    public VendingMachine() {
        this.balance = 0;
        this.selected = "";
        machineState = new IdleState();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public void reset(){
        this.selected = null;
        this.balance = 0;
    }

    public double priceOf(String coffee){
        switch (coffee){
            case "Latte": return 5.0;
            case "Cappucino" : return 10.0;
            default:   throw new IllegalArgumentException("enter a valid coffee name");
        }
    }

    public void insertMoney(double money) { machineState.insertMoney(this, money); }
    public void selectDrink(String coffee) { machineState.selectDrink(this, coffee); }
    public void dispenseDrink() { machineState.dispenseDrink(this); }
    public void cancelDrink() { machineState.cancelDrink(this); }
}
