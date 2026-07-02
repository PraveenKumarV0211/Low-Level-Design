package Entities;

import Enums.Color;
import Enums.PieceType;

public class King extends Piece{

    public King(Color color) {
        super(color, PieceType.KING);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int rowDiff = Math.abs(start.getRow() - end.getRow());
        int colDiff = Math.abs(start.getCol() - end.getCol());
        return rowDiff <= 1 && colDiff <= 1;
    }
}
