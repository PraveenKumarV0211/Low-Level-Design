package FactoryPattern;

import Enums.SeatType;

public abstract class Seat {
    String id;
    int row;
    int col;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Seat(String id, int row, int col, SeatType seatType) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
    }

    SeatType seatType;
    public abstract double getPrice();
}
