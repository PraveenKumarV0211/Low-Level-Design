package Test;

import Entities.*;
import Enums.*;
import Observer.*;
import Service.*;
import Strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AirCraft ac1 = new AirCraft(1, "Boeing 737", "IndiGo");
        AirCraft ac2 = new AirCraft(2, "Airbus A320", "SpiceJet");

        Flight f1 = new Flight(1, "F100", ac1, "BOS", "LAX", 5000, 300, 0);
        Flight f2 = new Flight(2, "F200", ac2, "BOS", "LAX", 3000, 400, 1);

        f1.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 1));
        f1.getAvailableSeats().add(new Seat(SeatType.BUSINESS, 2));
        f2.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 1));
        f2.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 2));

        // Test 1: Search with price strategy
        FlightSearch search = new FlightSearch(new PriceStrategy());
        BookingManager manager = new BookingManager(search);
        manager.addFlight(f1);
        manager.addFlight(f2);

        System.out.println("=== Search BOS -> LAX (by price) ===");
        List<Flight> results = manager.getFlights("BOS", "LAX");
        for (Flight f : results) {
            System.out.println(f.getName() + " | Price: " + f.getPrice());
        }

        // Test 2: Switch to duration strategy
        search.setSortStrategy(new DurationStrategy());
        System.out.println("\n=== Search BOS -> LAX (by duration) ===");
        results = manager.getFlights("BOS", "LAX");
        for (Flight f : results) {
            System.out.println(f.getName() + " | Duration: " + f.getDuration());
        }

        // Test 3: Book a seat — observer auto-registered
        Passenger p1 = new Passenger("Praveen", 25, "praveen@email.com");
        Passenger p2 = new Passenger("Rahul", 30, "rahul@email.com");

        Booking b1 = manager.makeBooking("BOS", "LAX", SeatType.ECONOMY, p1);
        Booking b2 = manager.makeBooking("BOS", "LAX", SeatType.ECONOMY, p2);

        System.out.println("\n=== Bookings ===");
        System.out.println(p1.getName() + " -> Flight: " + b1.getFlight().getName() + " Seat: " + b1.getSeat().getSeatNumber());
        System.out.println(p2.getName() + " -> Flight: " + b2.getFlight().getName() + " Seat: " + b2.getSeat().getSeatNumber());

        // Test 4: Flight status change — observers notified
        System.out.println("\n=== Flight F200 Delayed ===");
        f2.setStatus(FlightStatus.DELAYED);

        System.out.println("\n=== Flight F200 Cancelled ===");
        f2.setStatus(FlightStatus.CANCELLED);

        // Test 5: Cancel booking — seat freed
        manager.cancelBooking(b1);
        System.out.println("\n=== Booking Cancelled ===");
        System.out.println("Booking Status: " + b1.getBookingStatus());
        System.out.println("Seat Status: " + b1.getSeat().getSeatStatus());

        // Test 6: Cancel again — should throw
        try {
            manager.cancelBooking(b1);
        } catch (Exception e) {
            System.out.println("\n=== Expected Error ===");
            System.out.println(e.getMessage());
        }
    }
}