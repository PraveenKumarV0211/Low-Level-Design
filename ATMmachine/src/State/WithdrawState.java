package State;

import Entities.ATM;
import Entities.Account;

public class WithdrawState extends ATMStates {

    public WithdrawState(ATM atmMachine) {
        super(atmMachine);
    }

    @Override
    public void withdraw(double value) {
        Account account = atmMachine.getAccount();
        if (account.getBalance() < value) {
            System.out.println("Insufficient account balance.");
        } else if (atmMachine.getAtmBalance() < value) {
            System.out.println("ATM does not have enough cash.");
        } else {
            account.setBalance(account.getBalance() - value);
            atmMachine.setAtmBalance(atmMachine.getAtmBalance() - value);
            System.out.println("Withdrawn: " + value + ". Remaining balance: " + account.getBalance());
        }
        atmMachine.setAtmState(new SelectTransactionState(atmMachine));
    }
}