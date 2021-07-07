package org.example.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.common.ActiveParkingLot;
import org.example.exceptions.VehicleTypeMismatchException;
import org.example.models.Bike;
import org.example.models.Car;
import org.example.models.ParkingLot;

public class ParkCommand implements Command{

    private final Logger logger = LogManager.getLogger(ParkCommand.class);
    //Reg#, Color, Type
    String [] params;
    ActiveParkingLot activeParkingLot = ActiveParkingLot.getInstance();

    public ParkCommand(String[] params) {
        this.params = params;
    }

    @Override
    public boolean hasValidParams() {
        return (params != null && params.length == 3);
    }

    @Override
    public void execute() {
        ParkingLot parkingLot = activeParkingLot.getParkingLot();
        if (parkingLot != null) {
            if("CAR".equalsIgnoreCase(params[2])) {
                try {
                    parkingLot.park(new Car(params[0], params[1]));
                } catch (VehicleTypeMismatchException e) {
                    e.printStackTrace();
                }
            } else if("BIKE".equalsIgnoreCase(params[2])) {
                try {
                    parkingLot.park(new Bike(params[0], params[1]));
                } catch (VehicleTypeMismatchException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
