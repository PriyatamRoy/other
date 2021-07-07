package org.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.exceptions.ModeNotSupportedException;
import org.example.factory.ModeFactory;
import org.example.modes.Mode;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) throws ModeNotSupportedException {
        BasicConfigurator.configure();
        Mode mode = ModeFactory.getMode(args);
        logger.info(mode.toString());
        mode.process();
    }
}
