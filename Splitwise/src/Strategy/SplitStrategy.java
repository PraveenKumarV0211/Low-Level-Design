package Strategy;

import Models.Split;
import Models.User;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplits(double totalAmount, List<User> participants, List<Double> splitValues);
}
