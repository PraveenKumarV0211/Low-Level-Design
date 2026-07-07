package entities;

import enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Random;

public class Reservation {
    Random random;
    private int packageId;
    private int lockerID;
    private int lockerCellID;
    private int otp;
    private ReservationStatus reservationStatus;
    private LocalDateTime assignedAt;
    private LocalDateTime expiresAt;

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getLockerID() {
        return lockerID;
    }

    public void setLockerID(int lockerID) {
        this.lockerID = lockerID;
    }

    public int getLockerCellID() {
        return lockerCellID;
    }

    public void setLockerCellID(int lockerCellID) {
        this.lockerCellID = lockerCellID;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Reservation(int packageId, int lockerID, int lockerCellID, ReservationStatus reservationStatus) {
        this.packageId = packageId;
        this.lockerID = lockerID;
        this.lockerCellID = lockerCellID;
        this.reservationStatus = reservationStatus;
        this.assignedAt = LocalDateTime.now();
        this.expiresAt = this.assignedAt.plusDays(3);
        random = new Random();
        this.otp = random.nextInt(100);
    }



}
