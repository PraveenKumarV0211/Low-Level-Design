import Models.User;
import Service.Splitwise;

import java.util.Arrays;
import Enum.*;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();

        splitwise.addUser(new User("u1", "Alice", "alice@x.com"));
        splitwise.addUser(new User("u2", "Bob",   "bob@x.com"));
        splitwise.addUser(new User("u3", "Carol", "carol@x.com"));

//         Alice pays 900 for dinner, split equally among all three
        splitwise.addExpense("Dinner", 900, "u1",
                Arrays.asList("u1", "u2", "u3"), SplitType.EQUAL, null);
//
//        // Bob pays 1000, exact split: Bob 200, Alice 300, Carol 500
//        splitwise.addExpense("Groceries", 1000, "u2",
//                Arrays.asList("u2", "u1", "u3"), SplitType.EXACT,
//                Arrays.asList(200.0, 300.0, 500.0));

        System.out.println("--- All balances ---");
        splitwise.showBalances();

        System.out.println("--- Alice's balances ---");
        splitwise.showBalance("u1");
    }
}