package by.chmut.catalog.controller;

public class Controller{
    private final CommandDirector commandDirector = new CommandDirector();

    public String[] doAction(String request) {
        int index = getIndexForParse(request);
        String commandName = request.substring(0,index).trim();
        request = request.substring(index+1,request.length());
        if (request.length() == 0) {
            commandName = "error";
        }
        Command command = commandDirector.getCommand(commandName);

        String[] response = command.execute(request);

        return response;
    }

    private int getIndexForParse(String request) {
        int index=0;
        for (char currentChar: request.toCharArray()) {
            if (currentChar == '-') {
                return index;
            }
            index++;
        }
        return index;
    }
}
