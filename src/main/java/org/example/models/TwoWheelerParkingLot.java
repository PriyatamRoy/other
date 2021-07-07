package org.example.models;

import org.example.exceptions.VehicleTypeMismatchException;
import org.example.parkingstrategy.ParkingStrategy;

public class TwoWheelerParkingLot extends ParkingLot {

    private ParkingStrategy parkingStrategy;

    public TwoWheelerParkingLot(int capacity, ParkingStrategy parkingStrategy) {
        super("TWO_WHEELER", capacity);
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public int park(Vehicle vehicle) throws VehicleTypeMismatchException {
        throw new VehicleTypeMismatchException("Parking lot under construction. Cannot park now.");
    }
}
