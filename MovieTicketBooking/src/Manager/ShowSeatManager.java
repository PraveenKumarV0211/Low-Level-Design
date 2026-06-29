package Manager;

import Entities.Show;
import Enums.SeatStatus;
import FactoryPattern.Seat;
import Observer.SeatAvailabilityObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShowSeatManager {
    Show show;
    Map<String, SeatStatus> seatStatusMap;
    List<SeatAvailabilityObserver> observers;

    public ShowSeatManager(Show show) {
        this.show = show;
        this.seatStatusMap = new HashMap<>();
        observers = new ArrayList<>();
        for (Seat seat : show.getScreen().getSeats()) {
            seatStatusMap.put(seat.getId(), SeatStatus.AVAILABLE);
        }
    }

    public synchronized List<Seat> getAvailableSeats(){
        return show.getScreen().getSeats().stream().filter(seat -> seatStatusMap.get(seat.getId()) == SeatStatus.AVAILABLE).collect(Collectors.toList());
    }

    public void addObserver(SeatAvailabilityObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        int availability = (int) seatStatusMap.values().stream().filter(s -> s == SeatStatus.AVAILABLE).count();
        for(SeatAvailabilityObserver observer: observers){
            observer.onSeatUpdate(show,availability);
        }
    }

    public synchronized void confirmSeats(List<Seat> seats){
        for(Seat seat:seats){
            seatStatusMap.put(seat.getId(),SeatStatus.BOOKED);
        }
        notifyObservers();
    }
    public synchronized void releaseSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            seatStatusMap.put(seat.getId(), SeatStatus.AVAILABLE);
        }
        notifyObservers();
    }

    public synchronized boolean lockSeats(List<Seat> seats){
        for (Seat seat: seats){
            if(seatStatusMap.get(seat.getId()) != SeatStatus.AVAILABLE) {
                return false;
            }
        }
        for (Seat seat : seats){
            seatStatusMap.put(seat.getId(),SeatStatus.LOCKED);
        }
        notifyObservers();
        return true;
    }
}
