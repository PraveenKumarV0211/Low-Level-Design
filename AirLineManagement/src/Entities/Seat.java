package Entities;

import Enums.SeatStatus;
import Enums.SeatType;

public class Seat {
    private SeatType seatType;
    private int seatNumber;
    private SeatStatus seatStatus;

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Seat(SeatType seatType, int seatNumber) {
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.seatStatus = SeatStatus.FREE;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
