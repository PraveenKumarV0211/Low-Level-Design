package Strategy;

import Models.Split;
import Models.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        double share = Math.round((totalAmount / participants.size()) * 100.0) / 100.0;
        for (User user : participants) {
            splits.add(new Split(user, share));
        }
        return splits;
    }
}
