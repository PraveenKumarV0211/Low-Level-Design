import Entities.ATM;
import Entities.Account;
import Entities.Card;
import Enums.AccountType;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(1, 100000, "Boston", "Chase");

        Account account = new Account(1, "Praveen", 5000, 1234567890L, 1234, AccountType.SAVING);
        Card card = new Card(1234567890L, 1234, "Praveen", new Date());

        System.out.println("=== Insert Card ===");
        atm.getCurrentState().insertCard(card, account);

        System.out.println("\n=== Verify PIN ===");
        atm.getCurrentState().verifyPin(1234);

        System.out.println("\n=== Check Balance ===");
        atm.getCurrentState().checkBalance();

        System.out.println("\n=== Withdraw 1000 ===");
        atm.getCurrentState().withdraw(1000);

        System.out.println("\n=== Deposit 500 ===");
        atm.getCurrentState().deposit(500);

        System.out.println("\n=== Check Balance Again ===");
        atm.getCurrentState().checkBalance();

        System.out.println("\n=== Eject Card ===");
        atm.getCurrentState().ejectCard();

        System.out.println("\n=== Try withdraw after eject (should throw) ===");
        try {
            atm.getCurrentState().withdraw(100);
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
    }

/*
So we are going to build a atm machine,

so the flow is :
User enters the bank and first they insert the card,
once the card is inserted,customer enters the pin and then account details is fetched
customer can select to either withdraw and deposit cash,
so for withdraw, the customer can enter the amount to withdraw and check if it > current balance.
if it is ok, we then dispence the cash and update the balance
for deposit the same workflow,customer enters the amout to deposit and puts the amout in atm , and the balance is updated.
the customer can then logout and take out the card.


ATM


Interface ATMMachineStates
// - inserCard()
// - deposit()
// - withdraw()
// - verifyPin()
// - fetchBalance()

So with respect to states:

Idle()
 - insertCard() will take the card and validate the pin. it calls CardInserted state
 PinVerify() state
  - verifyPin() will verify pin
  if success transition to cardInserted state

SelectTransaction()
 - once the pin is verified, the user can deposit or withdraw cash. so depending on the users input check the balance to do it, if the balance is present change to Transaction state

Withdraw State()
    - in this state, the user will check balance and if sufficient funds are there then cash is withdrawn
    - if user wants to loggout, we can transition to Idle or we can go to card inserted state
 Deposit State()
    - in this state, the User will deposit cash and balance gets updated
    - if user wants to loggout, we can transition to Idle or we can go to card inserted state


ATM:
id;
CashInAtmMachine
location
bankName;
currentState(new IdleState(ATM)) -> account informatio


Account:
Username
AccountType
balance
cardNumber
Pin

Card:
CardNumber
NameinCard
ExpiryDate
pin




 */