package Model;

import java.util.List;
import java.util.Map;

public class Locker {
    private String id;
    private String location;
    private List<LockerCell> cells;
    private Map<String, LockerCell> pinToCell;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<LockerCell> getCells() {
        return cells;
    }

    public void setCells(List<LockerCell> cells) {
        this.cells = cells;
    }

    public Map<String, LockerCell> getPinToCell() {
        return pinToCell;
    }

    public void setPinToCell(Map<String, LockerCell> pinToCell) {
        this.pinToCell = pinToCell;
    }

    public Locker(String id, String location, List<LockerCell> cells) {
        this.id = id;
        this.location = location;
        this.cells = cells;
        this.pinToCell = pinToCell;
    }
}
