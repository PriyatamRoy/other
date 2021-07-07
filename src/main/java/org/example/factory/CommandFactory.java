package org.example.factory;

import org.example.commands.Command;
import org.example.commands.CreateParkingLotCommand;
import org.example.commands.ParkCommand;
import org.example.exceptions.CommandNotFoundException;

public class CommandFactory {
    public static Command getCommand(String cmdStr, String [] params) throws CommandNotFoundException {
        switch (cmdStr) {
            case "CREATE_PARKING_LOT":
                return new CreateParkingLotCommand(params);
            case "PARK":
                return new ParkCommand(params);
            default:
                throw new CommandNotFoundException("Command Not Found.");
        }
    }
}
