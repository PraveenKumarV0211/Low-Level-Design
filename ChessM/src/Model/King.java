package Model;

import Enum.Color;
public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board b, int r1, int c1, int r2, int c2) {
        return Math.max(Math.abs(r1-r2),Math.abs(c1-c2)) == 1;

    }
}
