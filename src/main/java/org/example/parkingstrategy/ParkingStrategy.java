package org.example.parkingstrategy;

import org.example.exceptions.ParkingFullException;
import org.example.models.Vehicle;

public interface ParkingStrategy {
    public int getNextAvailableSlot(Vehicle[] slots) throws ParkingFullException;
}
