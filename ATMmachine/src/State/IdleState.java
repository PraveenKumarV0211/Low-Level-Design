package State;

import Entities.ATM;
import Entities.Account;
import Entities.Card;

public class IdleState extends ATMStates {

    public IdleState(ATM atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card, Account account) {
        System.out.println("Card inserted. Please enter your PIN.");
        atmMachine.setAccount(account);
        atmMachine.setAtmState(new PinVerifyState(atmMachine, card));
    }
}