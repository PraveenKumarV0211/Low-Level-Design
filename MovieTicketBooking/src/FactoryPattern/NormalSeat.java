package FactoryPattern;

import Enums.SeatType;

public class NormalSeat extends Seat{
    public NormalSeat(String id, int row, int col) {
        super(id, row, col, SeatType.NORMAL);
    }
    @Override
    public double getPrice() {
        return 200;
    }
}
