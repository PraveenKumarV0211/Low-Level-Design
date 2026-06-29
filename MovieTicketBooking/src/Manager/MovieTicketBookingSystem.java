package Manager;

import Entities.Booking;
import Entities.Movie;
import Entities.Show;
import Entities.Theater;
import FactoryPattern.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieTicketBookingSystem {
    private static MovieTicketBookingSystem instance;

    private final List<Movie> movies;
    private final List<Theater> theaters;
    private final Map<String, Show> shows;
    private final Map<String, ShowSeatManager> showSeatManagers;
    private final Map<String, Booking> bookings;


    private MovieTicketBookingSystem() {
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.shows = new HashMap<>();
        this.showSeatManagers = new HashMap<>();
        this.bookings = new HashMap<>();

    }
    public List<Show> getShowsForMovie(String movieId) {
        return shows.values().stream()
                .filter(s -> s.getMovie().getId().equals(movieId))
                .collect(Collectors.toList());
    }

    public static synchronized MovieTicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new MovieTicketBookingSystem();
        }
        return instance;
    }
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    public void addTheater(Theater theater){
        theaters.add(theater);
    }

    public void addShow(Show show){
        shows.put(show.getId(), show);
        showSeatManagers.put(show.getId(),new ShowSeatManager(show));
    }

    public ShowSeatManager getSeatManager(String showId){
        return showSeatManagers.get(showId);
    }
    public List<Movie> getMovies(){
        return movies;
    }

    public List<Seat> getAvailableSeats(String showID){
        ShowSeatManager manager = showSeatManagers.get(showID);
        if(manager == null) throw  new RuntimeException("Show not found");
        return manager.getAvailableSeats();
    }
    public Booking createBooking(String userId, String showId, List<Seat> seats) {
        Show show = shows.get(showId);
        if (show == null) throw new RuntimeException("Show not found");

        ShowSeatManager manager = showSeatManagers.get(showId);

        // Step 1: Lock seats atomically
        if (!manager.lockSeats(seats)) {
            throw new RuntimeException("Seats unavailable");
        }

        // Step 2: Create pending booking (price from seat factory subclass)
        Booking booking = new Booking(userId, show, seats);
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) throw new RuntimeException("Booking not found");

        ShowSeatManager manager = showSeatManagers.get(booking.getShow().getId());
        manager.confirmSeats(booking.getSeats());
        booking.confirm();
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) throw new RuntimeException("Booking not found");

        ShowSeatManager manager = showSeatManagers.get(booking.getShow().getId());
        manager.releaseSeats(booking.getSeats());
        booking.cancel();
    }
}
