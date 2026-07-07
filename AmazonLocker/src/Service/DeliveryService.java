package Service;

import entities.Locker;
import entities.LockerCell;
import entities.Package;
import entities.Reservation;
import enums.ReservationStatus;
import enums.Size;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DeliveryService {
    private Locker locker;
    private Map<Integer,Reservation> reservations;

    public DeliveryService(Locker locker,Map<Integer,Reservation> reservations) {
        this.reservations = reservations;
        this.locker = locker;
    }

    public LockerCell checkAvailability(Size size) {
        List<LockerCell> lockerCells = locker.getLockerCellList();
        for (LockerCell lockerCell : lockerCells) {
            if (lockerCell.isAvailable() && lockerCell.getSize().compareTo(size) >= 0) {
                return lockerCell;
            }
        }
        return null;
    }

    public void addPackage(Package pack) throws Exception {
        LockerCell freeCell = checkAvailability(pack.getSize());
        if(Objects.isNull(freeCell)) {
            throw new Exception("There is no space in this locker. try another one nearby");
        }
        freeCell.setAvailable(false);
        Reservation reservation = new Reservation(pack.getId(), locker.getId(), freeCell.getId(), ReservationStatus.WAITING);
        reservations.put(reservation.getOtp(), reservation);
    }


}
