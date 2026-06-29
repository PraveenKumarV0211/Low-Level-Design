package Entities;

import Enums.BookingStatus;
import FactoryPattern.Seat;

import java.util.List;
import java.util.UUID;

public class Booking {
    private final String id;
    private final String userId;
    private final Show show;
    private final List<Seat> seats;
    private final double totalAmount;
    private BookingStatus status;

    public Booking(String userId, Show show, List<Seat> seats) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.show = show;
        this.seats = seats;
        this.totalAmount = seats.stream().mapToDouble(Seat::getPrice).sum();
        this.status = BookingStatus.PENDING;
    }

    public void confirm() { this.status = BookingStatus.CONFIRMED; }
    public void cancel() { this.status = BookingStatus.CANCELLED; }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public Show getShow() { return show; }
    public List<Seat> getSeats() { return seats; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatus getStatus() { return status; }
}
