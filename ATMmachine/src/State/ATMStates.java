package State;

import Entities.ATM;
import Entities.Account;
import Entities.Card;

public abstract class ATMStates {

    protected ATM atmMachine;

    public ATMStates(ATM atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void insertCard(Card card, Account account) {
        throw new UnsupportedOperationException("Insert card not allowed in current state");
    }

    public void verifyPin(int pin) {
        throw new UnsupportedOperationException("Verify PIN not allowed in current state");
    }

    public void deposit(double value) {
        throw new UnsupportedOperationException("Deposit not allowed in current state");
    }

    public void withdraw(double value) {
        throw new UnsupportedOperationException("Withdraw not allowed in current state");
    }

    public double checkBalance() {
        throw new UnsupportedOperationException("Check balance not allowed in current state");
    }

    public void ejectCard() {
        throw new UnsupportedOperationException("Eject card not allowed in current state");
    }
}