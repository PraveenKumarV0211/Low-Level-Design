package entities;

import java.util.List;

public class Locker {
    private int id;
    private List<LockerCell> lockerCellList;
    private double latitude;
    private double longitude;

    public Locker(int id, List<LockerCell> lockerCellList, double latitude, double longitude) {
        this.id = id;
        this.lockerCellList = lockerCellList;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LockerCell> getLockerCellList() {
        return lockerCellList;
    }

    public void setLockerCellList(List<LockerCell> lockerCellList) {
        this.lockerCellList = lockerCellList;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
