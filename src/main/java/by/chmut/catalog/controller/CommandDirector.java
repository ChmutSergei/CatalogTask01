package by.chmut.catalog.controller;

import by.chmut.catalog.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandDirector {

    private Map<String, Command> commands = new HashMap<String, Command>();


    public CommandDirector() {
        commands.put("read", new ReadCommand());
        commands.put("search", new SearchCommand());
        commands.put("add", new AddCommand());
        commands.put("save", new SaveCommand());
        commands.put("error", new ErrorCommand());
    }

    public Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command == null) {
            command = new ErrorCommand();
        }
        return command;
    }
}
