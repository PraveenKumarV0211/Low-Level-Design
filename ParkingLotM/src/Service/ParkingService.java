package Service;

import Model.Floor;
import Model.ParkingSlot;
import Model.Ticket;
import Model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enum.VehicleType;

public class ParkingService {

    Map<String, Ticket> parkedVehicles;
    List<Floor> floorList;


    public ParkingService(List<Floor> floorList) {
        this.parkedVehicles = new HashMap<>();
        this.floorList = floorList;
    }

    public Map<String, Ticket> getParkedVehicles() {
        return parkedVehicles;
    }

    public void setParkedVehicles(Map<String, Ticket> parkedVehicles) {
        this.parkedVehicles = parkedVehicles;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }


    public Ticket enterFacility(Vehicle vehicle){
        if (parkedVehicles.containsKey(vehicle.getLicensePlate())) {
            throw new IllegalStateException("Vehicle already parked: " + vehicle.getLicensePlate());
        }

        ParkingSlot availableParkingSlot = reserveSlot(vehicle.getType());
        if(availableParkingSlot == null){
            throw new IllegalStateException("There are No available space to park your vehicle. Sorry!");
        }

        Ticket parkingticket = new Ticket(LocalDateTime.now(),vehicle,availableParkingSlot);
        parkedVehicles.put(vehicle.getLicensePlate(), parkingticket);
        return parkingticket;
    }


    private ParkingSlot reserveSlot(VehicleType vehicleType){
        for(Floor floor : floorList){
            for (ParkingSlot slot : floor.getSlots()){
                if(!slot.isOccupied() && slot.getType() == vehicleType){
                    slot.setOccupied(true);
                    return slot;
                }
            }
        }
        return null;
    }


    public double exitVehicle(Ticket ticket){
        String plate = ticket.getVehicle().getLicensePlate();
        if (!parkedVehicles.containsKey(plate)) {
            throw new IllegalStateException("No active ticket for vehicle: " + plate);
        }
        double price = calculatePrice(ticket, LocalDateTime.now());
        ticket.getSlot().setOccupied(false);
        parkedVehicles.remove(plate);
        return price;
    }


    private double calculatePrice(Ticket ticket,LocalDateTime exitTime){
        LocalDateTime entryTime = ticket.getEntryTime();
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        long hours = Math.max(1, (long) Math.ceil(minutes / 60.0));
        return hours * ticket.getVehicle().getType().getPrice();

    }
}
