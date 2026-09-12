import Enum.VehicleType;
import Model.Floor;
import Model.ParkingSlot;
import Model.Ticket;
import Model.Vehicle;
import Service.ParkingService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Floor floor1 = new Floor(1, Arrays.asList(
                new ParkingSlot("F1-B1", VehicleType.BIKE),
                new ParkingSlot("F1-C1", VehicleType.CAR)));

        Floor floor2 = new Floor(2, Arrays.asList(
                new ParkingSlot("F2-C1", VehicleType.CAR),
                new ParkingSlot("F2-T1", VehicleType.TRUCK)));

        ParkingService service = new ParkingService(List.of(floor1, floor2));

        Vehicle car1 = new Vehicle("KA-01-1111", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-2222", VehicleType.CAR);
        Vehicle car3 = new Vehicle("KA-01-3333", VehicleType.CAR);

        Ticket t1 = service.enterFacility(car1);
        System.out.println("car1 parked at " + t1.getSlot().getId());

        Ticket t2 = service.enterFacility(car2);
        System.out.println("car2 parked at " + t2.getSlot().getId());

        try {
            service.enterFacility(car3);
        } catch (IllegalStateException e) {
            System.out.println("car3 rejected: " + e.getMessage());
        }

        try {
            service.enterFacility(car1);
        } catch (IllegalStateException e) {
            System.out.println("duplicate entry rejected: " + e.getMessage());
        }

        System.out.println("car1 exit charge: " + service.exitVehicle(t1));

        Ticket t3 = service.enterFacility(car3);
        System.out.println("car3 parked at " + t3.getSlot().getId());
    }
}

/*


Before you design anything, tell me:

What are the vehicle types and spot types, and how do they map to each other?
What are the core operations your system must support? Give me method names.
What decides the price?


Vehicle types:

car, truck, bike

slots also same types as vehicles

only cars to go cars spot and bikes go to bikes spot and same for truck

when user enters facility, we need to check for availability based on ehicle tpye and give them a parking ticket

and when they go out, we get the ticket calculate the price and charge them.

we can also support multiplt payment options but it is out of scope (like a strategy pattern)

if ticket is lost, we can get customer details and charge them based on their time of stay plus $50 for loss of ticket

usually they charge per hour basis, so we can go with that, for 1 hr, bike is 20, car is 50 and truck is 75


ive me the API. Method names, parameters, return types, no bodies:

entry flow
exit flow
lost ticket flow
what park returns when the lot is full


enum VehicleType { BIKE, CAR, TRUCK }

class Vehicle {
    String licensePlate;
    VehicleType type;
}

class ParkingSlot {
    String id;
    VehicleType type;
    boolean isOccupied;
}

class Floor {
    int floorNumber;
    List<ParkingSlot> slots;
}

class Ticket {
    String id;
    LocalDateTime entryTime;
    Vehicle vehicle;
    ParkingSlot slot;
}

class ParkingService {
    List<Floor> floors;
    Map<String, Ticket> activeTicketsByPlate;

    Ticket enterFacility(Vehicle vehicle);              // throws LotFullException
    double exitFacility(String ticketId);
    double exitWithLostTicket(String licensePlate);     // adds LOST_TICKET_FEE
    double calculatePrice(LocalDateTime in, LocalDateTime out, VehicleType type);
}


 */