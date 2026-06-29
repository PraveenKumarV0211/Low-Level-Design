package FactoryPattern;

import Enums.SeatType;

public class VIPSeat extends Seat{
    public VIPSeat(String id, int row, int col) {
        super(id, row, col, SeatType.VIP);
    }
    @Override
    public double getPrice(){
        return 1000;
    }
}
