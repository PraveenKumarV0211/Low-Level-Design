package Entities;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer,Integer> snakesAndLadders;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, Integer> getSnakesAndLadders() {
        return snakesAndLadders;
    }

    public void setSnakesAndLadders(Map<Integer, Integer> snakesAndLadders) {
        this.snakesAndLadders = snakesAndLadders;
    }

    public Board(int size) {
        this.size = size;
        this.snakesAndLadders = new HashMap<>();
    }

    public void addSnakeOrLadder(int src,int dest){
        snakesAndLadders.put(src,dest);
        // can check for duplicates
    }
}
