package State;

import Entities.ATM;
import Entities.Card;

public class PinVerifyState extends ATMStates {

    private Card card;

    public PinVerifyState(ATM atmMachine, Card card) {
        super(atmMachine);
        this.card = card;
    }

    @Override
    public void verifyPin(int pin) {
        if (card.getPin() == pin && atmMachine.getAccount().getPin() == pin) {
            System.out.println("PIN verified. Select a transaction.");
            atmMachine.setAtmState(new SelectTransactionState(atmMachine));
        } else {
            System.out.println("Incorrect PIN. Card ejected.");
            atmMachine.setAccount(null);
            atmMachine.setAtmState(new IdleState(atmMachine));
        }
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atmMachine.setAccount(null);
        atmMachine.setAtmState(new IdleState(atmMachine));
    }
}