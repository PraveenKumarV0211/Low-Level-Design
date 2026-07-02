package Entities;

import Enums.Color;
import Enums.PieceType;

public class Queen extends Piece{
    public Queen(Color color) { super(color, PieceType.QUEEN); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int rowDiff = Math.abs(start.getRow() - end.getRow());
        int colDiff = Math.abs(start.getCol() - end.getCol());
        return start.getRow() == end.getRow() || start.getCol() == end.getCol() || rowDiff == colDiff;
    }
}

