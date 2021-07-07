package org.example.factory;

import org.example.exceptions.ParkingLotNotSupportedException;
import org.example.models.FourWheelerParkingLot;
import org.example.models.ParkingLot;
import org.example.models.ParkingLotType;
import org.example.models.TwoWheelerParkingLot;
import org.example.parkingstrategy.FourWheelerParkingStrategy;
import org.example.parkingstrategy.TwoWheelerParkingStrategy;

public class ParkingLotFactory {
    public static ParkingLot getParkingLot(ParkingLotType type, int capacity) throws ParkingLotNotSupportedException {
        switch(type) {
            case FOUR_WHEELER:
                return new FourWheelerParkingLot(capacity, new FourWheelerParkingStrategy());
            case TWO_WHEELER:
                return new TwoWheelerParkingLot(capacity, new TwoWheelerParkingStrategy());
            default:
                throw new ParkingLotNotSupportedException("Parking lot not supported!");
        }
    }
}
