package Entities;

import Enums.FlightStatus;
import Enums.SeatType;
import Observer.FlightObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight {
    private int id;
    private String name;
    private AirCraft airCraft;
    private String source;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airCraft=" + airCraft +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", duration=" + duration +
                ", numberOfStops=" + numberOfStops +
                '}';
    }

    private String destination;
    private List<Seat> availableSeats;
    private int price;
    private int duration;
    private int numberOfStops;

    public Flight(int id, String name, AirCraft airCraft, String source, String destination, int price, int duration, int numberOfStops) {
        this.id = id;
        this.name = name;
        this.airCraft = airCraft;
        this.source = source;
        this.destination = destination;
        this.availableSeats = new ArrayList<>();
        this.price = price;
        this.duration = duration;
        this.numberOfStops = numberOfStops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats() {
        this.availableSeats = new ArrayList<>();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    private List<FlightObserver> observers = new ArrayList<>();
    private FlightStatus status;

    public void addObserver(FlightObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(FlightObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (FlightObserver observer : observers) {
            observer.update(this.name, this.status);
        }
    }
}
