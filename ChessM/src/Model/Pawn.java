package Model;

import Enum.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board b, int r1, int c1, int r2, int c2) {
        int dir = (color == Color.WHITE) ? -1 : 1;
        int start = (color == Color.WHITE) ? 6 : 1;
        Piece target = b.get(r2, c2);
        if (c1 == c2 && r2 == r1 + dir && target == null) return true;
        if (c1 == c2 && r1 == start && r2 == r1 + 2 * dir
                && target == null && b.get(r1 + dir, c1) == null) return true;
        return Math.abs(c1 - c2) == 1 && r2 == r1 + dir && target != null;
    }
}
