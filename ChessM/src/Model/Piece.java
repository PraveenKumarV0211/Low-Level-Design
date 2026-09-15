package Model;

import Enum.Color;
public abstract class Piece {
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board b, int r1, int c1, int r2, int c2);
}
