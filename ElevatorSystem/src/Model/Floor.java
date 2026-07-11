package Model;

public class Floor {
    private int floorNumber;
    private boolean upButton;
    private boolean downButton;

    public Floor(int floorNumber, boolean upButton, boolean downButton) {
        this.floorNumber = floorNumber;
        this.upButton = upButton;
        this.downButton = downButton;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isUpButton() {
        return upButton;
    }

    public void setUpButton(boolean upButton) {
        this.upButton = upButton;
    }

    public boolean isDownButton() {
        return downButton;
    }

    public void setDownButton(boolean downButton) {
        this.downButton = downButton;
    }
}
