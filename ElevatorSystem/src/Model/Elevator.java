package Model;

import State.ElevatorState;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int id;
    private int capacity;
    private Floor currentFloor;
    private List<Request> requestList;
    private ElevatorState elevatorState;

    public Elevator(int id, int capacity, Floor currnetFloor,  ElevatorState elevatorState) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = currnetFloor;
        this.requestList = new ArrayList<>();
        this.elevatorState = elevatorState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currnetFloor) {
        this.currentFloor = currnetFloor;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }
}
