package org.example.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.common.ActiveParkingLot;
import org.example.exceptions.ParkingLotNotSupportedException;
import org.example.factory.ParkingLotFactory;
import org.example.models.ParkingLot;
import org.example.models.ParkingLotType;

public class CreateParkingLotCommand implements Command{
    private final Logger logger = LogManager.getLogger(CreateParkingLotCommand.class);
    String [] params;
    ActiveParkingLot activeParkingLot = ActiveParkingLot.getInstance();

    public CreateParkingLotCommand(String [] params) {
        this.params = params;
    }

    @Override
    public boolean hasValidParams() {
        return params != null && params.length == 2;
    }

    @Override
    public void execute() {
        if ("FOUR_WHEELER".equals(params[0])) {
            try {
                ParkingLot parkingLot = ParkingLotFactory.getParkingLot(ParkingLotType.FOUR_WHEELER, Integer.parseInt(params[1]));
                activeParkingLot.setParkingLot(parkingLot);
                logger.info("Created "  + parkingLot.getType()  + " parking lot with capacity: " + parkingLot.getCapacity());
            } catch (ParkingLotNotSupportedException e) {
                e.printStackTrace();
            }
        } else {
            logger.error("Incorrect parking lot type entered.");
        }
    }
}
