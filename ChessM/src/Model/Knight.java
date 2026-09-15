package Model;

import Enum.Color;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board b, int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) * Math.abs(c1 - c2) == 2;
    }
}
