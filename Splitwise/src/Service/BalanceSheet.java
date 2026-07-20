package Service;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    public void updateBalance(String ownedBy, String ownedTo, double amount) {
        balances.computeIfAbsent(ownedBy, k -> new HashMap<>()).merge(ownedTo, amount, Double::sum);
        balances.computeIfAbsent(ownedTo, k -> new HashMap<>()).merge(ownedBy, -amount, Double::sum);
    }


    public void showBalances() {
        boolean anyDebt = false;
        for (String debtor : balances.keySet()) {
            for (Map.Entry<String, Double> e : balances.get(debtor).entrySet()) {
                if (e.getValue() > 0.01) {
                    anyDebt = true;
                    System.out.println(debtor + " owes " + e.getKey() + ": " + e.getValue());
                }
            }
        }
        if (!anyDebt) System.out.println("Everyone is settled Up");
    }

    public void showBalancesForUser(String userId) {
        Map<String, Double> userBalances = balances.getOrDefault(userId, new HashMap<>());
        for (Map.Entry<String, Double> e : userBalances.entrySet()) {
            if (e.getValue() > 0.01) {
                System.out.println(userId + " owes " + e.getKey() + ": " + e.getValue());
            } else if (e.getValue() < -0.01) {
                System.out.println(e.getKey() + " owes " + userId + ": " + (-e.getValue()));
            }
        }
    }

    Map<String, Map<String, Double>> getBalances() {
        return balances;
    }
}
