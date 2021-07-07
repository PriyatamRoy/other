package org.example.parkingstrategy;

import org.example.exceptions.ParkingFullException;
import org.example.models.Vehicle;

public class TwoWheelerParkingStrategy implements ParkingStrategy {
    @Override
    public int getNextAvailableSlot(Vehicle[] slots) throws ParkingFullException {
        for (int i = slots.length - 1; i > 0; i--) {
            if (slots[i] == null) {
                return i;
            }
        }
        throw new ParkingFullException("Parking Full!");
    }
}
