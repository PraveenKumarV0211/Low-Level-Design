package Service;

import Model.Board;
import Enum.Color;
import Model.King;
import Model.Piece;

public class Game {
    private Board board;
    private Color turn = Color.WHITE;
    boolean move(int r1,int c1,int r2,int c2){
        Piece p = board.get(r1,c1);
        if (p == null || p.getColor() != turn){
            return false;
        }
        Piece target = board.get(r2,c2);
        if (target != null && target.getColor() == turn) return false;
        if (!p.canMove(board,r1,c1,r2,c2)) return false;

        if (isCheck(turn)) {
            board.set(r1, c1, p);
            board.set(r2, c2, target);
            return false;
        }
        turn = (turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
        return true;
    }
    boolean isCheck(Color color) {
        int kr = -1, kc = -1;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = board.get(r, c);
                if (p instanceof King && p.color == color) { kr = r; kc = c; }
            }
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = board.get(r, c);
                if (p != null && p.color != color && p.canMove(board, r, c, kr, kc)) return true;
            }
        return false;
    }
}
