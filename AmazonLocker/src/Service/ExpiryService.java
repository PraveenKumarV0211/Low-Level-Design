package service;

import entities.Locker;
import entities.LockerCell;
import entities.Reservation;
import enums.ReservationStatus;
import observer.ExpiryObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExpiryService {
    private Map<Integer, Reservation> reservationMap;
    private Locker locker;
    private List<ExpiryObserver> observers;

    public ExpiryService(Map<Integer, Reservation> reservationMap, Locker locker) {
        this.reservationMap = reservationMap;
        this.locker = locker;
        this.observers = new ArrayList<>();
    }

    public void addObserver(ExpiryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ExpiryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Reservation reservation) {
        for (ExpiryObserver observer : observers) {
            observer.onReservationExpired(reservation);
        }
    }

    public void checkAndExpireReservations() {
        Iterator<Map.Entry<Integer, Reservation>> iterator = reservationMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Reservation> entry = iterator.next();
            Reservation reservation = entry.getValue();

            if (reservation.getReservationStatus() == ReservationStatus.WAITING
                    && LocalDateTime.now().isAfter(reservation.getExpiresAt())) {
                reservation.setReservationStatus(ReservationStatus.EXPIRED);
                freeUpLockerCell(reservation);
                notifyObservers(reservation);
                iterator.remove();
            }
        }
    }

    private void freeUpLockerCell(Reservation reservation) {
        for (LockerCell cell : locker.getLockerCellList()) {
            if (cell.getId() == reservation.getLockerCellID()) {
                cell.setAvailable(true);
                break;
            }
        }
    }
}