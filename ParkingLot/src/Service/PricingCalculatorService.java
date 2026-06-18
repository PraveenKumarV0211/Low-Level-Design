package Service;

import Domain.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class PricingCalculatorService
{
    Map<Vehicle.VehicleType, Double> prices = new HashMap<>();
    public  PricingCalculatorService()
    {
    initialize();
    }
    public void initialize()
    {
        prices.put(Vehicle.VehicleType.CAR, 3.0);
        prices.put(Vehicle.VehicleType.BIKE, 5.0);
        prices.put(Vehicle.VehicleType.TRUCK, 10.0);
    }

    public Double  getPrice(Vehicle.VehicleType type)
    {
        return prices.get(type);
    }

}
