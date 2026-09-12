package Model;

import Enums.Colours;

public class Board {
    private final int rows;
    private final int cols;
    private final Colours[][] grid;
    private int filledCells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Colours[rows][cols];
        this.filledCells = 0;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Colours getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean isFull() {
        return filledCells == rows * cols;
    }

    // Gravity: lowest empty row in the column, or -1 if the column is full.
    public int getLowestEmptyRow(int col) {
        if (col < 0 || col >= cols) {
            return -1;
        }
        for (int r = rows - 1; r >= 0; r--) {
            if (grid[r][col] == null) {
                return r;
            }
        }
        return -1;
    }

    public void place(int row, int col, Colours colour) {
        grid[row][col] = colour;
        filledCells++;
    }
}