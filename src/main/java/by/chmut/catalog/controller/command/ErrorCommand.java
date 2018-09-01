package by.chmut.catalog.controller.command;

import by.chmut.catalog.bean.News;
import by.chmut.catalog.view.View;

import java.util.HashSet;
import java.util.Set;

public class ErrorCommand implements by.chmut.catalog.controller.Command {
    @Override
    public String[] execute(String request) {

        String error = "Incorrect command or no data in the command! Try again!";

        String[] response = {error};

        return response;
    }
}
