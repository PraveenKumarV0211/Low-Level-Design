package Service;

import entities.Locker;
import entities.LockerCell;
import entities.Package;
import entities.Reservation;
import enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class PickUpService {
    Map<Integer, Reservation> reservationMap;
    Locker locker;

    public PickUpService(Map<Integer, Reservation> reservationMap, Locker locker) {
        this.locker = locker;
        this.reservationMap = reservationMap;
    }

    public void pickUp(int otp) throws Exception {
        if (!reservationMap.containsKey(otp)) {
            throw new Exception("sorry the package is not here in this locker");
        }
        Reservation reservation = reservationMap.get(otp);
        if (LocalDateTime.now().isAfter(reservation.getExpiresAt())) {
            reservation.setReservationStatus(ReservationStatus.EXPIRED);
            freeUpLockerCell(reservation);
            reservationMap.remove(otp);
            throw new Exception("The package has expired. Contact support.");
        }
        System.out.println("Package is found. Auth with the code");


        reservation.setReservationStatus(ReservationStatus.PICKED);
        freeUpLockerCell(reservation);
        reservationMap.remove(otp);
    }

    public void freeUpLockerCell(Reservation reservation){
        for (LockerCell lockerCell : locker.getLockerCellList()){
            if(lockerCell.getId() == reservation.getLockerCellID()){
                lockerCell.setAvailable(true);
            }
        }
    }
}
