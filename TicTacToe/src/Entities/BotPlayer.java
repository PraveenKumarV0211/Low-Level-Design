package Entities;

import Enum.*;
import Strategy.BotPlayerStrategy;

public class BotPlayer extends Player {

    BotPlayerStrategy strategy;
    public BotPlayer(String name, int age, String userName, Symbol symbol,BotPlayerStrategy strategy) {
        super(name, age, userName, symbol);
        this.strategy = strategy;
    }

    public Move getMove(Board board){
        return strategy.makeMove(board);
    }


}
