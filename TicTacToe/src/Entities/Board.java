package Entities;

import Enum.*;
public class Board {
    private Cell[][] board;
    int numberOfMoves;

    public Board(int m, int n) {
        this.board = new Cell[m][n];
        this.numberOfMoves = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Symbol s = board[i][j].getSymbol();
                System.out.print((s == null ? "-" : s) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
