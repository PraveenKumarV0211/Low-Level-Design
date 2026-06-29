package FactoryPattern;

import Enums.SeatType;

public class PremiumSeat extends Seat{
    public PremiumSeat(String id, int row, int col) {
        super(id, row, col, SeatType.PREMIUM);
    }
    @Override
    public double getPrice(){
        return 500;
    }
}
