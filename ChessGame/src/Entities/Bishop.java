package Entities;

import Enums.Color;
import Enums.PieceType;

public class Bishop extends Piece {
    public Bishop(Color color) { super(color, PieceType.BISHOP); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int rowDiff = Math.abs(start.getRow() - end.getRow());
        int colDiff = Math.abs(start.getCol() - end.getCol());
        return rowDiff == colDiff;
    }
}