package Strategy;

import Entities.Board;
import Entities.Move;

public class RandomPlayStrategy implements BotPlayerStrategy {
    @Override
    public Move makeMove(Board board) {

        int size = board.getBoard().length;
        if (board.getNumberOfMoves() == size * size) {
            throw new RuntimeException();
        }
        boolean moveSet = false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getBoard()[i][j].getSymbol() == null){
                    return new Move(i,j);
                }
            }
        }
        return new Move(0,0);


    }
}
