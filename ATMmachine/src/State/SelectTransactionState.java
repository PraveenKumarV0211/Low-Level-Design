package State;

import Entities.ATM;

public class SelectTransactionState extends ATMStates {

    public SelectTransactionState(ATM atmMachine) {
        super(atmMachine);
    }

    @Override
    public void deposit(double value) {
        System.out.println("Transitioning to Deposit state.");
        atmMachine.setAtmState(new DepositState(atmMachine));
        atmMachine.getCurrentState().deposit(value);
    }

    @Override
    public void withdraw(double value) {
        System.out.println("Transitioning to Withdraw state.");
        atmMachine.setAtmState(new WithdrawState(atmMachine));
        atmMachine.getCurrentState().withdraw(value);
    }

    @Override
    public double checkBalance() {
        double balance = atmMachine.getAccount().getBalance();
        System.out.println("Current balance: " + balance);
        return balance;
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected. Returning to Idle.");
        atmMachine.setAccount(null);
        atmMachine.setAtmState(new IdleState(atmMachine));
    }
}