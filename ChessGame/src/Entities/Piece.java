package Entities;

import Enums.Color;
import Enums.PieceType;

public abstract class Piece {
    private Color color;
    private PieceType pieceType;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    public abstract boolean canMove(Board board,Cell start, Cell end);
}
