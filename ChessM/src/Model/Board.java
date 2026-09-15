package Model;

public class Board {
    Piece[][] board = new Piece[8][8];

    public Piece get(int r, int c) {
        return board[r][c];
    }

    public void set(int r, int c, Piece p) {
        board[r][c] = p;
    }

    boolean clearPath(int r1, int c1, int r2, int c2) {
        int dr = Integer.signum(r2 - r1), dc = Integer.signum(c2 - c1);
        int r = r1 + dr, c = c1 + dc;
        while (r != r2 || c != c2) {
            if (board[r][c] != null) return false;
            r += dr;
            c += dc;
        }
        return true;
    }
}
