import Enums.Colours;
import Enums.MoveResult;
import Service.Game;
import Model.Board;
import Model.Player;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 7);
        Player p1 = new Player(1, "Alice", Colours.RED);
        Player p2 = new Player(2, "Bob", Colours.BLUE);
        Game game = new Game(p1, p2, board);

        int[] moves = {0, 0, 1, 1, 2, 2, 3};

        for (int col : moves) {
            Player mover = game.getCurrentPlayer();
            MoveResult result = game.makeMove(col);

            if (result == MoveResult.INVALID) {
                System.out.println("Invalid move in column " + col);
                continue;
            }

            System.out.println(mover + " dropped in column " + col);
            printBoard(board);

            if (result == MoveResult.WIN) {
                System.out.println("Winner: " + game.getWinner());
                break;
            }
            if (result == MoveResult.DRAW) {
                System.out.println("Game is drawn");
                break;
            }
        }
    }

    private static void printBoard(Board board) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                Colours cell = board.getCell(r, c);
                System.out.print((cell == null ? "." : cell.name().charAt(0)) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}