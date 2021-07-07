package org.example.common;

import org.example.models.ParkingLot;

public class ActiveParkingLot {
    private static ActiveParkingLot instance;
    private ParkingLot parkingLot = null;

    private ActiveParkingLot() {
    }

    synchronized public static ActiveParkingLot getInstance() {
        if(instance == null) {
            instance = new ActiveParkingLot();
        }
        return instance;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
