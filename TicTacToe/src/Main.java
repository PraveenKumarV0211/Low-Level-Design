import Entities.BotPlayer;
import Entities.Player;
import Service.Game;
import Enum.*;
import Strategy.RandomPlayStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player human = new Player("Praveen", 26, "Praveen#18", Symbol.X);
        BotPlayer bot = new BotPlayer("Bot", 0, "Bot#1", Symbol.O, new RandomPlayStrategy());
        Game game = new Game(3, List.of(human, bot));

        Scanner scanner = new Scanner(System.in);
        GameStatus status = GameStatus.IN_PROGRESS;

        while (status == GameStatus.IN_PROGRESS) {
            game.getBoard().printBoard();
            if (game.getCurrentPlayer() instanceof BotPlayer) {
                System.out.println("Bot's turn...");
                status = game.makeMove(-1, -1);
            } else {
                System.out.println("Your turn (row col): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                try {
                    status = game.makeMove(row, col);
                } catch (RuntimeException e) {
                    System.out.println("Invalid move, try again");
                    continue;
                }
            }
        }
        game.getBoard().printBoard();
        System.out.println("Result: " + status);
    }

    public static GameStatus playMove(Game game, int row, int col) {
        while (true) {
            try {
                return game.makeMove(row, col);
            } catch (RuntimeException e) {
                col = (col + 1) % 3; // shift to next cell
            }
        }
    }

}