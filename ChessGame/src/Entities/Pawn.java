package Entities;

import Enums.Color;
import Enums.PieceType;

public class Pawn extends Piece {
    public Pawn(Color color) { super(color, PieceType.PAWN); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int direction = getColor() == Color.WHITE ? -1 : 1; // white moves up, black moves down
        int startingRow = getColor() == Color.WHITE ? 6 : 1;

        int rowDiff = end.getRow() - start.getRow();
        int colDiff = Math.abs(start.getCol() - end.getCol());

        // forward 1
        if (rowDiff == direction && colDiff == 0 && end.isEmpty()) {
            return true;
        }
        // forward 2 from starting row
        if (rowDiff == 2 * direction && colDiff == 0 && start.getRow() == startingRow && end.isEmpty()) {
            return true;
        }
        // diagonal capture
        if (rowDiff == direction && colDiff == 1 && !end.isEmpty() && end.getPiece().getColor() != getColor()) {
            return true;
        }
        return false;
    }
}