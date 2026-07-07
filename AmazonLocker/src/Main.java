import entities.*;
import entities.Package;
import enums.Size;
import observer.AgentNotificationObserver;
import observer.CustomerNotificationObserver;
import Service.DeliveryService;
import service.ExpiryService;
import Service.PickUpService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Setup locker with cells of various sizes
        List<LockerCell> cells = new ArrayList<>();
        cells.add(new LockerCell(1, Size.SMALL));
        cells.add(new LockerCell(2, Size.SMALL));
        cells.add(new LockerCell(3, Size.MEDIUM));
        cells.add(new LockerCell(4, Size.LARGE));

        Locker locker = new Locker(1, cells, 42.3601, -71.0589);

        // Shared reservation map (OTP -> Reservation)
        Map<Integer, Reservation> reservationMap = new HashMap<>();

        // Services
        DeliveryService deliveryService = new DeliveryService(locker, reservationMap);
        PickUpService pickUpService = new PickUpService(reservationMap, locker);
        ExpiryService expiryService = new ExpiryService(reservationMap, locker);
        expiryService.addObserver(new CustomerNotificationObserver());
        expiryService.addObserver(new AgentNotificationObserver());

        // Users
        User user1 = new User("Praveen", 25, 1234567890L, "praveen@email.com");
        User user2 = new User("John", 30, 9876543210L, "john@email.com");

        // Packages
        Package pkg1 = new Package(101, Size.SMALL, user1, 5001);
        Package pkg2 = new Package(102, Size.MEDIUM, user2, 5002);
        Package pkg3 = new Package(103, Size.LARGE, user1, 5003);

        try {
            // --- Delivery flow ---
            System.out.println("=== DELIVERY ===");
            deliveryService.addPackage(pkg1);
            System.out.println("Package 101 (SMALL) delivered.");

            deliveryService.addPackage(pkg2);
            System.out.println("Package 102 (MEDIUM) delivered.");

            deliveryService.addPackage(pkg3);
            System.out.println("Package 103 (LARGE) delivered.");

            // Print OTPs for testing
            System.out.println("\n=== ACTIVE RESERVATIONS ===");
            for (Map.Entry<Integer, Reservation> entry : reservationMap.entrySet()) {
                Reservation r = entry.getValue();
                System.out.println("PackageID: " + r.getPackageId()
                        + " | CellID: " + r.getLockerCellID()
                        + " | OTP: " + entry.getKey()
                        + " | Status: " + r.getReservationStatus());
            }

            // --- Pickup flow ---
            System.out.println("\n=== PICKUP ===");
            int otpToPickup = reservationMap.keySet().iterator().next(); // grab first OTP
            System.out.println("Customer enters OTP: " + otpToPickup);
            pickUpService.pickUp(otpToPickup);
            System.out.println("Pickup successful!");

            // --- Invalid OTP ---
            System.out.println("\n=== INVALID OTP TEST ===");
            try {
                pickUpService.pickUp(999999);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // --- No space test ---
            System.out.println("\n=== NO SPACE TEST ===");
            Package pkg4 = new Package(104, Size.LARGE, user2, 5004);
            try {
                deliveryService.addPackage(pkg4);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // --- Expiry check (won't expire anything since we just created them) ---
            System.out.println("\n=== EXPIRY CHECK ===");
            expiryService.checkAndExpireReservations();
            System.out.println("Expiry check done. Remaining reservations: " + reservationMap.size());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}