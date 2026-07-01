package Service;

import Entities.Booking;
import Entities.Flight;
import Entities.Passenger;
import Entities.Seat;
import Enums.BookingStatus;
import Enums.SeatStatus;
import Enums.SeatType;
import Observer.EmailNotificationObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookingManager {
    private FlightSearch search;
    public List<Flight> flights;
    private Random random;


    public BookingManager(FlightSearch flightSearch) {
        this.search = flightSearch;
        this.flights = new ArrayList<>();
        random = new Random();
    }

    public FlightSearch getSearch() {
        return search;
    }

    public void setSearch(FlightSearch search) {
        this.search = search;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public Booking makeBooking(String src, String dest, SeatType seatType, Passenger passenger) throws Exception {
        if(src.equals(dest)){
            throw new IllegalArgumentException("Src can not be same as destination");
        }

        List<Flight> matchingflights = getFlights(src,dest);
        boolean availableSeat = false;
        Booking booking = null;
        for (Flight flight : matchingflights){
            if (availableSeat) break;
            List<Seat> seats = flight.getAvailableSeats();
            for (Seat seat : seats){
                if (seat.getSeatType() == seatType && seat.getSeatStatus() == SeatStatus.FREE){
                    availableSeat = true;
                    booking = new Booking(random.nextInt(), passenger, BookingStatus.ON_PROGRESS,seat,flight);
                    seat.setSeatStatus(SeatStatus.HOLD);
                    flight.addObserver(new EmailNotificationObserver(passenger.getName(), passenger.getEmail()));
                    break;
                }
            }
        }
        if(!availableSeat){
            throw new Exception("No Seat available for this type");
        }
        return booking;
    }


    public void cancelBooking(Booking booking) throws Exception {
        if (booking.getBookingStatus().equals(BookingStatus.CANCELLED)){
            throw new Exception("Cancelled ticket can not be cancelled again");
        }

        booking.setBookingStatus(BookingStatus.CANCELLED);
        Seat seat = booking.getSeat();
        seat.setSeatStatus(SeatStatus.FREE);
        //process repayment

    }

    public List<Flight> getFlights(String src, String dest){
        List<Flight> matchingFlights = search.searchFlights(flights,src,dest);
        return matchingFlights;
    }


}
