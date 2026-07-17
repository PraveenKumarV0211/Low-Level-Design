package Entities;

import java.util.Random;

public class Dice {
    private int minValue;
    private int maxValue;
    Random random;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        random = new Random();
    }

    public int roll(){
        return random.nextInt(minValue,maxValue+1);
    }
}
