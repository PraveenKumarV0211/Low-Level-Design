import Enums.Size;
import Model.Customer;
import Model.Locker;
import Model.LockerCell;
import Model.Package;
import Service.LockerService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LockerCell> cells = new ArrayList<>();
        cells.add(new LockerCell("C1", Size.SMALL));
        cells.add(new LockerCell("C2", Size.MEDIUM));
        cells.add(new LockerCell("C3", Size.LARGE));

        Locker locker = new Locker("L1", "Fremont", cells);
        LockerService service = new LockerService(locker);

        Customer c = new Customer(1, "Praveen");
        Package p1 = new Package(101, Size.SMALL, c);
        Package p2 = new Package(102, Size.SMALL, c);
        Package p3 = new Package(103, Size.SMALL, c);
        Package p4 = new Package(104, Size.SMALL, c);
        Package p5 = new Package(105, Size.LARGE, c);

        String pin1 = service.addPackage(p1);
        System.out.println("p1 pin: " + pin1);
        printCells(cells);

        String pin2 = service.addPackage(p2);
        String pin3 = service.addPackage(p3);
        System.out.println("p2 pin: " + pin2 + ", p3 pin: " + pin3);
        printCells(cells);

        System.out.println("p4 (locker full): " + service.addPackage(p4));

        Package picked = service.removePackage(pin1);
        System.out.println("picked up: " + (picked == null ? "null" : picked.getId()));
        printCells(cells);

        System.out.println("reuse pin1: " + service.removePackage(pin1));
        System.out.println("bad pin:    " + service.removePackage("0000"));
        System.out.println("null pin:   " + service.removePackage(null));

        System.out.println("p5 LARGE (only SMALL free): " + service.addPackage(p5));
    }

    private static void printCells(List<LockerCell> cells) {
        for (LockerCell cell : cells) {
            System.out.print(cell.getId() + "=" + (cell.isOccupied() ? "OCCUPIED" : "free") + "  ");
        }
        System.out.println("\n");
    }
}

// Amazon locker

// delivery guy puts the packange into the locker with specific size
// pin is generated

// customer goes to the locker , enters the pin and takes out the package
// locker is freed

// Locker size varies Small, medium, large
// Package Size small, medium, large

// Locker Cell -> id, Size, isOccupied
// Locker -> id, location, List<LockerCells>, Map<pin,LockerCell>
// Package -> id, size, customer
// Customer -> id, name, pin
// LockerService -> locker , addpackage, remove package
// lockerService will take locker obj as instance and work on it, once the package is added otp is generated and it is sent on both locker and customer
// while pickup customer enters the pin and retrives the package and lockercell is emtied
