package org.example.commands;

import org.example.exceptions.ParkingLotNotSupportedException;

public interface Command {
    public boolean hasValidParams();
    public void execute();
}
