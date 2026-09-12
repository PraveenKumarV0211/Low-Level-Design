package Service;

import Enums.GameStatus;
import Enums.MoveResult;
import Model.Board;
import Model.Player;

public class Game {
    private static final int WIN_LENGTH = 4;
    Player p1;
    Player p2;
    Board board;
    Player currentPlayer;
    Player winner;
    GameStatus gameStatus;

    public Game(Player player1, Player player2, Board board) {
        this.p1 = player1;
        this.p2 = player2;
        this.board = board;
        this.currentPlayer = player1;
        winner = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public MoveResult makeMove(int col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            return MoveResult.INVALID;
        }

        int row = board.getLowestEmptyRow(col);
        if (row == -1) {
            return MoveResult.INVALID;
        }

        board.place(row, col, currentPlayer.getCoinColour());

        if (isWinner(currentPlayer, row, col)) {
            winner = currentPlayer;
            gameStatus = GameStatus.FINISHED;
            return MoveResult.WIN;
        }

        if (board.isFull()) {
            gameStatus = GameStatus.DRAW;
            return MoveResult.DRAW;
        }

        switchPlayer();
        return MoveResult.SUCCESS;
    }

    private boolean isWinner(Player player, int row, int col) {
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

        for (int[] dir : directions) {
            int count = 1
                    + countInDirection(player, row, col, dir[0], dir[1])
                    + countInDirection(player, row, col, -dir[0], -dir[1]);
            if (count >= WIN_LENGTH) {
                return true;
            }
        }
        return false;
    }

    private int countInDirection(Player player, int row, int col, int dRow, int dCol) {
        int count = 0;
        int r = row + dRow;
        int c = col + dCol;

        while (board.isInBounds(r, c) && player.getCoinColour() == board.getCell(r, c)) {
            count++;
            r += dRow;
            c += dCol;
        }
        return count;
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Board getBoard() {
        return board;
    }




}
