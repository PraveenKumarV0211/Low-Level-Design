package Strategy;

import Entities.Board;
import Entities.Move;

public interface BotPlayerStrategy {
    public Move makeMove(Board board);
}
