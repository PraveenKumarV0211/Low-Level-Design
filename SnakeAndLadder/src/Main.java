

import Entities.*;
import Enum.GameStatus;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);

        // Snakes
        board.addSnakeOrLadder(99, 10);
        board.addSnakeOrLadder(65, 25);
        board.addSnakeOrLadder(45, 6);

        // Ladders
        board.addSnakeOrLadder(8, 32);
        board.addSnakeOrLadder(15, 78);
        board.addSnakeOrLadder(28, 56);

        Dice dice = new Dice(1, 6);

        Queue<Player> players = new LinkedList<>();
        players.add(new Player("Alice", 1));
        players.add(new Player("Bob", 2));

        Game game = new Game(dice, board, players);

        while (game.getGameStatus() == GameStatus.RUNNING) {
            game.playMove();
        }

        System.out.println("Winner: " + game.getWinner().getName());
    }
}