package Entities;

import Enums.Color;
import Enums.PieceType;

public class Rook extends Piece {
    public Rook(Color color) { super(color, PieceType.ROOK); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        return start.getRow() == end.getRow() || start.getCol() == end.getCol();
    }
}