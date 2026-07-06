package entities;

import java.util.List;

public class Locker {
    private int id;
    private List<LockerCell> lockerCellList;
    private long latitude;
    private long longitude;

    public Locker(int id, List<LockerCell> lockerCellList, long latitude, long longitude) {
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

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
