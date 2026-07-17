package Entities;

import Enum.GameStatus;

import java.util.Queue;

public class Game {
    private Dice dice;
    private Board board;
    private Queue<Player> players;
    private GameStatus gameStatus;
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }


    public Game(Dice dice, Board board, Queue<Player> players) {
        this.dice = dice;
        this.board = board;
        this.players = players;
        this.gameStatus = GameStatus.RUNNING;
        this.winner = null;
    }


    public void playMove(){
        Player currentPlayer = players.poll();
        int currentPosition = currentPlayer.getCurrentPosition();

        int diceVal = dice.roll();
        int nextMove = diceVal + currentPosition;
        if(nextMove > board.getSize()){
            System.out.println("this move is out of scope of the board. Wait for next move");
            players.add(currentPlayer);
            return;
        }
        if(nextMove == board.getSize()){
            System.out.println("Congrats, you reached the end. Youa re the winner");
            setGameStatus(GameStatus.FINISHED);
            setWinner(currentPlayer);
            return;
        }

        currentPlayer.setCurrentPosition(nextMove);

        //Hitting a snake or ladder
        if(board.getSnakesAndLadders().containsKey(nextMove)){
            int jumpValue = board.getSnakesAndLadders().get(nextMove);
            if(jumpValue > currentPosition){
                System.out.println("You hit ladder");
                currentPlayer.setCurrentPosition(jumpValue);
            }
            else{
                System.out.println("You hit snake");
                currentPlayer.setCurrentPosition(jumpValue);
            }
        }

        players.add(currentPlayer);
    }
}
