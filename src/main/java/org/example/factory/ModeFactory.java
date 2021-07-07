package org.example.factory;

import org.example.exceptions.ModeNotSupportedException;
import org.example.modes.CommandPromtMode;
import org.example.modes.FileMode;
import org.example.modes.Mode;

public class ModeFactory {
    public static Mode getMode(String [] args) throws ModeNotSupportedException {
        if(args != null && args.length == 0) {
            return new CommandPromtMode();
        } else if(args != null && args.length  == 1) {
            return new FileMode();
        } else {
            throw new ModeNotSupportedException("Invalid arguments.");
        }
    }
}
