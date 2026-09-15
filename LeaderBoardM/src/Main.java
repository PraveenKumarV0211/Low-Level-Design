

import Model.Player;
import Service.Game;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();

        Player alice = new Player(1, "Alice", 0);
        Player bob = new Player(2, "Bob", 0);
        Player carol = new Player(3, "Carol", 0);
        Player dave = new Player(4, "Dave", 0);

        game.addPlayer(alice);
        game.addPlayer(bob);
        game.addPlayer(carol);
        game.addPlayer(dave);

        game.addScore(alice, 90);
        game.addScore(bob, 50);
        game.addScore(carol, 50);
        game.addScore(dave, 20);

        printTop(game, 3);
        printRanks(game);

        System.out.println("-- Dave gains 40 --");
        game.addScore(dave, 40);

        printTop(game, 3);
        printRanks(game);

        try {
            game.addPlayer(new Player(1, "Duplicate", 0));
        } catch (Exception e) {
            System.out.println("Expected: " + e.getMessage());
        }
    }

    private static void printTop(Game game, int k) {
        List<Player> top = game.getTopKScores(k);
        System.out.print("Top " + k + ": ");
        for (Player p : top) {
            System.out.print(p.getName() + "(" + p.getScore() + ") ");
        }
        System.out.println();
    }

    private static void printRanks(Game game) throws Exception {
        for (int id = 1; id <= 4; id++) {
            System.out.print("id " + id + " rank " + game.getRank(id) + "  ");
        }
        System.out.println();
    }
}