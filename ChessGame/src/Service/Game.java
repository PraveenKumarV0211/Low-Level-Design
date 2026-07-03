package Service;

import Entities.Board;
import Entities.Cell;
import Entities.Piece;
import Entities.Player;
import Enums.Color;
import Enums.GameStatus;
import Enums.PieceType;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private GameStatus status;

    public Game() {
        board = new Board();
        board.initializeBoard();
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);
        currentPlayer = whitePlayer;
        status = GameStatus.ACTIVE;
    }

    public boolean makeMove(int startRow, int startCol, int endRow, int endCol) {
        if (status != GameStatus.ACTIVE) {
            return false;
        }

        Cell start = board.getCell(startRow, startCol);
        Cell end = board.getCell(endRow, endCol);

        // 1. Is there a piece at start belonging to current player?
        if (start.isEmpty() || start.getPiece().getColor() != currentPlayer.getColor()) {
            return false;
        }

        Piece piece = start.getPiece();

        // 2. Does the piece's movement shape allow this?
        if (!piece.canMove(board, start, end)) {
            return false;
        }

        // 3. Is the path clear? (skip for knight)
        if (piece.getPieceType() != PieceType.KNIGHT && !board.isPathClear(start, end)) {
            return false;
        }

        // 4. Not capturing own piece?
        if (!end.isEmpty() && end.getPiece().getColor() == currentPlayer.getColor()) {
            return false;
        }

        // 5. Does this move leave my king in check? (simulate and check)
        Piece capturedPiece = end.getPiece();
        end.setPiece(piece);
        start.setPiece(null);

        boolean leavesKingInCheck = isKingInCheck(currentPlayer.getColor());

        if (leavesKingInCheck) {
            // undo
            start.setPiece(piece);
            end.setPiece(capturedPiece);
            return false;
        }

        // Move is valid — check game state
        Color opponentColor = currentPlayer == whitePlayer ? Color.BLACK : Color.WHITE;

        if (isCheckmate(opponentColor)) {
            status = currentPlayer == whitePlayer ? GameStatus.WHITE_WIN : GameStatus.BLACK_WIN;
        } else if (isStalemate(opponentColor)) {
            status = GameStatus.STALEMATE;
        }

        // Switch turn
        currentPlayer = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
        return true;
    }

    private boolean isKingInCheck(Color kingColor) {
        Cell kingCell = findKing(kingColor);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isEmpty() || cell.getPiece().getColor() == kingColor) {
                    continue;
                }
                Piece enemy = cell.getPiece();
                if (enemy.canMove(board, cell, kingCell)
                        && (enemy.getPieceType() == PieceType.KNIGHT || board.isPathClear(cell, kingCell))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCheckmate(Color color) {
        if (!isKingInCheck(color)) {
            return false;
        }
        return !hasAnyLegalMove(color);
    }

    private boolean isStalemate(Color color) {
        if (isKingInCheck(color)) {
            return false;
        }
        return !hasAnyLegalMove(color);
    }

    private boolean hasAnyLegalMove(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell start = board.getCell(i, j);
                if (start.isEmpty() || start.getPiece().getColor() != color) {
                    continue;
                }
                Piece piece = start.getPiece();

                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        Cell end = board.getCell(r, c);
                        if (!piece.canMove(board, start, end)) continue;
                        if (piece.getPieceType() != PieceType.KNIGHT && !board.isPathClear(start, end)) continue;
                        if (!end.isEmpty() && end.getPiece().getColor() == color) continue;

                        // simulate
                        Piece captured = end.getPiece();
                        end.setPiece(piece);
                        start.setPiece(null);

                        boolean stillInCheck = isKingInCheck(color);

                        // undo
                        start.setPiece(piece);
                        end.setPiece(captured);

                        if (!stillInCheck) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private Cell findKing(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                if (!cell.isEmpty() && cell.getPiece().getColor() == color
                        && cell.getPiece().getPieceType() == PieceType.KING) {
                    return cell;
                }
            }
        }
        throw new RuntimeException("King not found");
    }

    public GameStatus getStatus() { return status; }
    public Player getCurrentPlayer() { return currentPlayer; }
}