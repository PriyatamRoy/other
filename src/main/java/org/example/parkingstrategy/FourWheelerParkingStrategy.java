package org.example.parkingstrategy;

import org.example.exceptions.ParkingFullException;
import org.example.models.Vehicle;

public class FourWheelerParkingStrategy implements ParkingStrategy {

    public FourWheelerParkingStrategy() {
    }

    public int getNextAvailableSlot(Vehicle[] slots) throws ParkingFullException {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                return i;
            }
        }
        throw new ParkingFullException("Parking Full!");
    }
}
