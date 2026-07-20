package Service;

import Models.Expense;
import Models.Split;
import Models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Enum.*;
import Strategy.SplitStrategy;

public class Splitwise {
    private final Map<String, User> users = new HashMap<>();
    private final List<Expense> expenses = new ArrayList<>();
    private final BalanceSheet balanceSheet = new BalanceSheet();
    private int expenseCounter = 0;

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void addExpense(String description, double amount, String paidByID, List<String> participantsID, SplitType type, List<Double> splitValues){
        User paidBy = users.get(paidByID);
        List<User> participants = new ArrayList<>();
        for (String id : participantsID){
            participants.add(users.get(id));
        }
        SplitStrategy strategy = SplitStrategyFactory.getStrategy(type);
        List<Split> splits = strategy.calculateSplits(amount,participants,splitValues);

        Expense expense = new Expense("EXP" + (++expenseCounter) , description, amount,paidBy,splits);
        expenses.add(expense);

        for (Split split : splits){
            if(!split.getUser().getUserId().equals(paidByID)){
                balanceSheet.updateBalance(split.getUser().getUserId(),paidByID,split.getAmount());
            }
        }
    }

    public void showBalances()            { balanceSheet.showBalances(); }
    public void showBalance(String userId) { balanceSheet.showBalancesForUser(userId); }
}
