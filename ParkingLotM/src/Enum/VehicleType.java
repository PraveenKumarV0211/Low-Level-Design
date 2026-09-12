package Enum;

public enum VehicleType {
    BIKE(20.0), CAR(50.0), TRUCK(80.0);
    double price;

    VehicleType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}
