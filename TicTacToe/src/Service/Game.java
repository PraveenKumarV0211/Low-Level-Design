package Service;

import Entities.Board;
import Entities.BotPlayer;
import Entities.Move;
import Entities.Player;
import Enum.*;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private WinChecker winChecker;
    private int currentPlayerIndex;

    public Game(int size, List<Player> players) {
        this.board = new Board(size, size);
        this.players = players;
        this.winChecker = new WinChecker();
        this.currentPlayerIndex = 0;
    }

    public GameStatus makeMove(int row, int col) {

        if (players.get(currentPlayerIndex) instanceof BotPlayer bot) {
            Move move = bot.getMove(board);
            row = move.getRow();
            col = move.getCol();
        }

        if(board.getBoard()[row][col].getSymbol() != null){
            System.out.println("This cell is already occupied");
            throw new RuntimeException();
        }


        board.getBoard()[row][col].setSymbol(players.get(currentPlayerIndex).getSymbol());
        board.setNumberOfMoves(board.getNumberOfMoves() + 1);
        GameStatus status = winChecker.WinCheck(board, row, col, players.get(currentPlayerIndex).getSymbol());
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        board.printBoard();
        return status;
    }
    public Board getBoard() { return board; }
    public Player getCurrentPlayer() { return players.get(currentPlayerIndex); }



}
