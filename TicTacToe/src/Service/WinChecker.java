package Service;

import Entities.Board;
import Enum.*;

public class WinChecker {

    public GameStatus WinCheck(Board board, int row, int col, Symbol symbol) {
        int size = board.getBoard().length;

        boolean rowWin = true;
        for (int i = 0; i < size; i++) {
            if (board.getBoard()[row][i].getSymbol() != symbol) {
                rowWin = false;
                break;
            }
        }

        boolean colWin = true;
        for (int i = 0; i < size; i++) {
            if (board.getBoard()[i][col].getSymbol() != symbol) {
                colWin = false;
                break;
            }
        }

        boolean diagWin = false;
        if (row == col) {
            diagWin = true;
            for (int i = 0; i < size; i++) {
                if (board.getBoard()[i][i].getSymbol() != symbol) {
                    diagWin = false;
                    break;
                }
            }
        }

        boolean antiDiagWin = false;
        if (row + col == size - 1) {
            antiDiagWin = true;
            for (int i = 0; i < size; i++) {
                if (board.getBoard()[i][size - 1 - i].getSymbol() != symbol) {
                    antiDiagWin = false;
                    break;
                }
            }
        }

        if (rowWin || colWin || diagWin || antiDiagWin) return GameStatus.WIN;
        if (board.getNumberOfMoves() == size * size) return GameStatus.DRAW;
        return GameStatus.IN_PROGRESS;
    }
}
