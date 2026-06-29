package FactoryPattern;

import Enums.SeatType;

public class SeatFactory {
    public static Seat createSeat(String id, int row, int col, SeatType type) {
        switch (type){
            case NORMAL : return new NormalSeat(id, row, col);
            case PREMIUM : return new PremiumSeat(id, row, col);
            case VIP : return new VIPSeat(id, row, col);
        };
        return null;
    }
}
