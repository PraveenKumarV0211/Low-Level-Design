package State;

import Entities.ATM;
import Entities.Account;

public class DepositState extends ATMStates {

    public DepositState(ATM atmMachine) {
        super(atmMachine);
    }

    @Override
    public void deposit(double value) {
        Account account = atmMachine.getAccount();
        account.setBalance(account.getBalance() + value);
        atmMachine.setAtmBalance(atmMachine.getAtmBalance() + value);
        System.out.println("Deposited: " + value + ". New balance: " + account.getBalance());
        atmMachine.setAtmState(new SelectTransactionState(atmMachine));
    }
}