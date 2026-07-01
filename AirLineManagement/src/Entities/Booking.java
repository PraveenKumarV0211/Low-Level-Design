package Entities;

import Enums.BookingStatus;

public class Booking {
    private int id;
    private Passenger passenger;
    private BookingStatus bookingStatus;
    private Seat seat;
    private Flight flight;

    public Booking(int id, Passenger passenger, BookingStatus bookingStatus, Seat seat, Flight flight) {
        this.id = id;
        this.passenger = passenger;
        this.bookingStatus = bookingStatus;
        this.seat = seat;
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
