package Service;

import Strategy.EqualSplitStrategy;
import Strategy.SplitStrategy;
import Enum.*;

public class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType type){
        switch (type){
            case EQUAL -> {
                return new EqualSplitStrategy();
            }
            default -> throw new IllegalArgumentException("Unknown Split type");
        }
    }
}
