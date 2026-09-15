package Model;

import Enum.Color;
public class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board b, int r1, int c1, int r2, int c2) {
        return ((r1 == r2) || ( c1 == c2) ) && b.clearPath(r1,c1,r2,c2);
    }
}
