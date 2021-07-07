package org.example.models;

import org.example.exceptions.ParkingFullException;
import org.example.exceptions.SlotNotFoundException;
import org.example.exceptions.VehicleTypeMismatchException;
import org.example.parkingstrategy.ParkingStrategy;

public class FourWheelerParkingLot extends ParkingLot{
    private ParkingStrategy parkingStrategy;

    public FourWheelerParkingLot(int capacity, ParkingStrategy parkingStrategy) {
        super("FOUR_WHEELER", capacity);
        this.parkingStrategy = parkingStrategy;
    }


    @Override
    public int park(Vehicle vehicle) throws VehicleTypeMismatchException {
        if (vehicle.getVehicleType() != VehicleType.FOUR_WHEELER) {
            throw new VehicleTypeMismatchException("Cannot park this vehicle in " + getType() + " parking lot.");
        }
        try {
            int slotNumber = parkingStrategy.getNextAvailableSlot(getSlots());
            if(park(slotNumber, vehicle)) {
                return slotNumber;
            } else {
                return -1;
            }
        } catch (ParkingFullException | SlotNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
