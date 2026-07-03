package Entities;

import Enums.Color;

public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }
    public void initializeBoard() {
        // Black major pieces - row 0
        cells[0][0].setPiece(new Rook(Color.BLACK));
        cells[0][1].setPiece(new Knight(Color.BLACK));
        cells[0][2].setPiece(new Bishop(Color.BLACK));
        cells[0][3].setPiece(new Queen(Color.BLACK));
        cells[0][4].setPiece(new King(Color.BLACK));
        cells[0][5].setPiece(new Bishop(Color.BLACK));
        cells[0][6].setPiece(new Knight(Color.BLACK));
        cells[0][7].setPiece(new Rook(Color.BLACK));

        // Black pawns - row 1
        for (int j = 0; j < 8; j++) {
            cells[1][j].setPiece(new Pawn(Color.BLACK));
        }

        // White pawns - row 6
        for (int j = 0; j < 8; j++) {
            cells[6][j].setPiece(new Pawn(Color.WHITE));
        }

        // White major pieces - row 7
        cells[7][0].setPiece(new Rook(Color.WHITE));
        cells[7][1].setPiece(new Knight(Color.WHITE));
        cells[7][2].setPiece(new Bishop(Color.WHITE));
        cells[7][3].setPiece(new Queen(Color.WHITE));
        cells[7][4].setPiece(new King(Color.WHITE));
        cells[7][5].setPiece(new Bishop(Color.WHITE));
        cells[7][6].setPiece(new Knight(Color.WHITE));
        cells[7][7].setPiece(new Rook(Color.WHITE));
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isPathClear(Cell start, Cell end) {
        int rowDiff = end.getRow() - start.getRow();
        int colDiff = end.getCol() - start.getCol();

        int rowDir = Integer.signum(rowDiff);
        int colDir = Integer.signum(colDiff);

        int currentRow = start.getRow() + rowDir;
        int currentCol = start.getCol() + colDir;

        while (currentRow != end.getRow() || currentCol != end.getCol()) {
            if (!cells[currentRow][currentCol].isEmpty()) {
                return false;
            }
            currentRow += rowDir;
            currentCol += colDir;
        }

        return true;
    }

}
