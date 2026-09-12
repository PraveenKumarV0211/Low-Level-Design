package Service;

import Model.Locker;
import Model.LockerCell;
import Model.Package;

import java.util.List;
import java.util.Random;

public class LockerService {
    private Locker locker;

    public LockerService(Locker locker) {
        this.locker = locker;
    }

    public String addPackage(Package pack){
        List<LockerCell> lockerCellList = locker.getCells();
        LockerCell availableCell = null;
        for(LockerCell cell : lockerCellList){
            if(!cell.isOccupied() && cell.getSize().getCapacity() >= pack.getSize().getCapacity()){
                availableCell = cell;
                break;
            }
        }

        if(availableCell != null){
            System.out.println("There is a free space available");
            availableCell.setCurrentPackage(pack);
            availableCell.setOccupied(true);
            System.out.println("generate OTP");
            String pin = generateOTP();
            locker.getPinToCell().put(pin, availableCell);
            return pin;
        }

        return null;
    }


    private String generateOTP(){
        String pin;
        do {
            pin = String.valueOf(1000 + new Random().nextInt(9000));
        } while (locker.getPinToCell().containsKey(pin));
        return pin;
    }


    public Package removePackage(String pin){
        if(pin == null || pin.isEmpty()){
            return null;
        }
        LockerCell lock = locker.getPinToCell().get(pin);
        if(lock != null){
            Package pack = lock.getCurrentPackage();
            lock.setCurrentPackage(null);
            lock.setOccupied(false);
            locker.getPinToCell().remove(pin);
            return pack;
        }
        return null;
    }
}
