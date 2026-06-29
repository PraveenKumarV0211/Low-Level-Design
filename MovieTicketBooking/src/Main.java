import Entities.*;
import Enums.SeatType;
import FactoryPattern.Seat;
import FactoryPattern.SeatFactory;
import Manager.MovieTicketBookingSystem;
import Manager.ShowSeatManager;
import Observer.NotificationService;
import Observer.SeatAvailabilityDisplay;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieTicketBookingSystem system = MovieTicketBookingSystem.getInstance();

        // ============================
        // Part 1 & 2: Models + Factory
        // ============================
        Movie inception = new Movie("M1", "Inception", 148);
        Movie interstellar = new Movie("M2", "Interstellar", 169);
        system.addMovie(inception);
        system.addMovie(interstellar);

        // Theater 1: PVR with 2 screens
        Screen screen1 = new Screen("S1", "Screen 1");
        screen1.addSeat(SeatFactory.createSeat("S1-A1", 1, 1, SeatType.NORMAL));
        screen1.addSeat(SeatFactory.createSeat("S1-A2", 1, 2, SeatType.NORMAL));
        screen1.addSeat(SeatFactory.createSeat("S1-B1", 2, 1, SeatType.PREMIUM));
        screen1.addSeat(SeatFactory.createSeat("S1-B2", 2, 2, SeatType.VIP));

        Screen screen2 = new Screen("S2", "Screen 2");
        screen2.addSeat(SeatFactory.createSeat("S2-A1", 1, 1, SeatType.NORMAL));
        screen2.addSeat(SeatFactory.createSeat("S2-A2", 1, 2, SeatType.PREMIUM));

        Theater pvr = new Theater("T1", "PVR Cinemas", "Boston");
        pvr.addScreen(screen1);
        pvr.addScreen(screen2);
        system.addTheater(pvr);

        // Theater 2: INOX with 1 screen
        Screen screen3 = new Screen("S3", "Screen 1");
        screen3.addSeat(SeatFactory.createSeat("S3-A1", 1, 1, SeatType.NORMAL));
        screen3.addSeat(SeatFactory.createSeat("S3-A2", 1, 2, SeatType.PREMIUM));
        screen3.addSeat(SeatFactory.createSeat("S3-B1", 2, 1, SeatType.VIP));

        Theater inox = new Theater("T2", "INOX", "Cambridge");
        inox.addScreen(screen3);
        system.addTheater(inox);

        // Shows: Inception at PVR Screen 1 and INOX Screen 1, Interstellar at PVR Screen 2
        Show show1 = new Show("SH1", inception, pvr, screen1, LocalDateTime.now().plusHours(2));
        Show show2 = new Show("SH2", inception, inox, screen3, LocalDateTime.now().plusHours(3));
        Show show3 = new Show("SH3", interstellar, pvr, screen2, LocalDateTime.now().plusHours(4));
        system.addShow(show1);
        system.addShow(show2);
        system.addShow(show3);

        // ============================
        // Part 4: Register Observers
        // ============================
        system.getSeatManager("SH1").addObserver(new SeatAvailabilityDisplay("PVR Website"));
        system.getSeatManager("SH1").addObserver(new NotificationService());
        system.getSeatManager("SH2").addObserver(new SeatAvailabilityDisplay("INOX Website"));
        system.getSeatManager("SH2").addObserver(new NotificationService());

        // ============================
        // Part 5: Browse Flow
        // ============================
        System.out.println("=== All Movies ===");
        for (Movie m : system.getMovies()) {
            System.out.println(m.getId() + " | " + m.getTitle());
        }

        System.out.println("\n=== Shows for Inception ===");
        List<Show> inceptionShows = system.getShowsForMovie("M1");
        for (Show s : inceptionShows) {
            System.out.println(s.getId() + " | " + s.getTheater().getName()
                    + " | " + s.getScreen().getName() + " | " + s.getStartTime());
        }

        System.out.println("\n=== Available Seats: PVR Screen 1 (SH1) ===");
        List<Seat> sh1Seats = system.getAvailableSeats("SH1");
        for (Seat s : sh1Seats) {
            System.out.println(s.getId() + " | " + s.getSeatType() + " | ₹" + s.getPrice());
        }

        // ============================
        // Part 5: Booking Flow
        // ============================

        // User 1 books Normal + VIP at PVR
        System.out.println("\n=== User 1: Book at PVR (SH1) ===");
        Booking b1 = system.createBooking("U1", "SH1",
                Arrays.asList(sh1Seats.get(0), sh1Seats.get(3))); // S1-A1, S1-B2
        System.out.println("Booking: " + b1.getId() + " | Status: " + b1.getStatus()
                + " | Total: ₹" + b1.getTotalAmount());

        system.confirmBooking(b1.getId());
        System.out.println("After confirm: " + b1.getStatus());

        // User 2 tries same seat at PVR — fails
        System.out.println("\n=== User 2: Try Same Seat at PVR ===");
        try {
            system.createBooking("U2", "SH1", List.of(sh1Seats.get(0)));
        } catch (RuntimeException e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // User 2 books at INOX instead — different show, no conflict
        System.out.println("\n=== User 2: Book at INOX (SH2) ===");
        List<Seat> sh2Seats = system.getAvailableSeats("SH2");
        Booking b2 = system.createBooking("U2", "SH2", List.of(sh2Seats.get(0)));
        system.confirmBooking(b2.getId());
        System.out.println("Booking: " + b2.getId() + " | Status: " + b2.getStatus()
                + " | Total: ₹" + b2.getTotalAmount());

        // User 1 cancels PVR booking
        System.out.println("\n=== User 1: Cancel PVR Booking ===");
        system.cancelBooking(b1.getId());
        System.out.println("Booking status: " + b1.getStatus());

        // User 3 now books the freed seats at PVR
        System.out.println("\n=== User 3: Book Freed Seats at PVR ===");
        sh1Seats = system.getAvailableSeats("SH1");
        System.out.println("Available now: " + sh1Seats.size());
        Booking b3 = system.createBooking("U3", "SH1", sh1Seats); // book all 4
        system.confirmBooking(b3.getId());
        System.out.println("Booking: " + b3.getId() + " | Status: " + b3.getStatus()
                + " | Total: ₹" + b3.getTotalAmount());

        // Final check — PVR should be sold out
        System.out.println("\n=== Final: PVR Availability ===");
        System.out.println("Available: " + system.getAvailableSeats("SH1").size());
    }
}