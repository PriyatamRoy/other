package org.example.modes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.commands.Command;
import org.example.exceptions.CommandNotFoundException;
import org.example.factory.CommandFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandPromtMode implements Mode {
    private final Logger logger = LogManager.getLogger(CommandPromtMode.class);
    private final String SPACE = " ";
    Scanner sc;

    public CommandPromtMode() {
        sc = new Scanner(System.in);
    }

    @Override
    public void process() {
        while (true) {
            String line = sc.nextLine();
            logger.info(line);
            List<String> tokens = Arrays.stream(line.trim().split(SPACE))
                    .map(String::trim).filter(token -> token.length() > 0)
                    .collect(Collectors.toList());
            logger.info(tokens.size());
            if(tokens.size() > 0) {
                String cmdStr = tokens.remove(0);
                String[] params = tokens.toArray(new String[0]);

                try {
                    Command command = CommandFactory.getCommand(cmdStr, params);
                    if(command.hasValidParams()) {
                        command.execute();
                    }
                } catch (CommandNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "CommandPromptMode";
    }
}
