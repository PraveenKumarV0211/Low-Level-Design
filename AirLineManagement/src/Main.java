

import Entities.*;
import Enums.*;
import Service.*;
import Strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create aircraft
        AirCraft aircraft1 = new AirCraft(1, "Boeing 737", "IndiGo");
        AirCraft aircraft2 = new AirCraft(2, "Airbus A320", "SpiceJet");

        // Create flights
        Flight f1 = new Flight(1, "F100", aircraft1, "BOS", "LAX", 5000, 300, 0);
        Flight f2 = new Flight(2, "F200", aircraft2, "BOS", "LAX", 3000, 400, 1);
        Flight f3 = new Flight(3, "F300", aircraft1, "BOS", "NYC", 2000, 120, 0);

        // Add seats to flights
        f1.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 1));
        f1.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 2));
        f1.getAvailableSeats().add(new Seat(SeatType.BUSINESS, 3));

        f2.getAvailableSeats().add(new Seat(SeatType.ECONOMY, 1));
        f2.getAvailableSeats().add(new Seat(SeatType.BUSINESS, 2));

        // Setup search with price strategy
        FlightSearch search = new FlightSearch(new PriceStrategy());
        BookingManager manager = new BookingManager(search);
        manager.addFlight(f1);
        manager.addFlight(f2);
        manager.addFlight(f3);

        // Test search
        List<Flight> results = manager.getFlights("BOS", "LAX");
        System.out.println("=== Search BOS -> LAX (sorted by price) ===");
        for (Flight f : results) {
            System.out.println(f.getName() + " | Price: " + f.getPrice() + " | Stops: " + f.getNumberOfStops());
        }

        // Test booking
        Passenger p1 = new Passenger("Praveen", 25, "praveen@email.com");
        Booking b1 = manager.makeBooking("BOS", "LAX", SeatType.ECONOMY, p1);
        System.out.println("\n=== Booking Created ===");
        System.out.println("Booking ID: " + b1.getId());
        System.out.println("Flight: " + b1.getFlight().getName());
        System.out.println("Seat: " + b1.getSeat().getSeatNumber() + " | Status: " + b1.getSeat().getSeatStatus());

        // Test cancel
        manager.cancelBooking(b1);
        System.out.println("\n=== Booking Cancelled ===");
        System.out.println("Booking Status: " + b1.getBookingStatus());
        System.out.println("Seat Status: " + b1.getSeat().getSeatStatus());

        // Test cancel again — should throw
        try {
            manager.cancelBooking(b1);
        } catch (Exception e) {
            System.out.println("\n=== Expected Error ===");
            System.out.println(e.getMessage());
        }
    }
}